package org.example.hexlet.dto.controllers;

import static io.javalin.rendering.template.TemplateUtil.model;

import io.javalin.validation.ValidationException;
import org.example.hexlet.dto.NamedRoutes;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import java.util.List;
import java.util.Optional;

public class CoursesController {
    public static void index(Context ctx) {
        var term = ctx.queryParam("term");
        List<Course> courses;
        if (term != null) {
            courses = CourseRepository.search(term);
        } else {
            courses = CourseRepository.getEntities();
        }
        CoursesPage page = new CoursesPage("Список доступных курсов", courses, term);
        ctx.contentType("text/html; charset=utf-8");
        ctx.render("pages/courses.jte", model("coursesPage", page));
    }

    public static void show(Context ctx) {
        Long id = ctx.pathParamAsClass("id", Long.class).get();
        Course course = CourseRepository.find(id).get();
        CoursePage page = new CoursePage("Курс: " + course.getTitle(), course);
        ctx.contentType("text/html; charset=utf-8");

        ctx.render("pages/course.jte", model("coursePage", page));
    }

    public static void build(Context ctx) {
        var page = new BuildUserPage();
        ctx.render("users/build.jte", model("buildPage", page));
    }

    public static void create(Context ctx) {
        ctx.contentType("text/html; charset=utf-8");
        var name = ctx.formParam("name").trim();
        var email = ctx.formParam("email").toLowerCase().trim();
        try {
            var passwordConfirmation = ctx.formParam("passwordConfirmation");
            var password = ctx.formParamAsClass("password", String.class)
                    .check(o -> o.equals(passwordConfirmation), "Пароли не совпадают")
                    .get();
            var user = new User(name, email, password);
            UserRepository.save(user);
            ctx.redirect("/users");
        } catch (ValidationException e) {
            BuildUserPage page = new BuildUserPage("Заполните форму заново", name, email, e.getErrors());
            ctx.render("users/build.jte", model("buildPage", page));
        }
    }

    public static void edit(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        var page = new UserPage("", user);
        ctx.render("users/edit.jte", model("page", page));
    }


    public static void update(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();

        var name = ctx.formParam("name");
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");

        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        UserRepository.save(user);
        ctx.redirect(NamedRoutes.usersPath());
    }

    public static void destroy(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        UserRepository.delete(id);
        ctx.redirect(NamedRoutes.usersPath());
    }
}