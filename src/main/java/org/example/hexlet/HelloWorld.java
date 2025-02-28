package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.Page;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        List<Course> listOfCourses = List.of(
                new Course(1L, "Курс по JS", "Лучший курс в РФ!"),
                new Course(2L, "Курс по PHP", "Лучший курс в СНГ?"),
                new Course(3L, "Курс по JAVA", "Лучший курс в СССР?")
        );
        listOfCourses.forEach(CourseRepository::save); ;

        app.get("/courses", ctx -> {
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
        });

        app.get("/courses/{id}", ctx -> {
            Long id = ctx.pathParamAsClass("id", Long.class).get();
            Course course = CourseRepository.find(id).get();
            CoursePage page = new CoursePage("Курс: " + course.getTitle(), course);
            ctx.contentType("text/html; charset=utf-8");

            ctx.render("pages/course.jte", model("coursePage", page));
        });

        app.get("/users/build", ctx -> {
            Page page = new Page("Создание пользователя");
            ctx.render("users/build.jte", model("buildPage", page));
        });

        app.post("/users", ctx -> {
            ctx.contentType("text/html; charset=utf-8");
            var name = ctx.formParam("name").trim();
            var email = ctx.formParam("email").toLowerCase().trim();
            var password = ctx.formParam("password");
            var passwordConfirmation = ctx.formParam("passwordConfirmation");

            var user = new User(name, email, password);
            UserRepository.save(user);
            ctx.redirect("/users");
        });

        app.get("/users", ctx -> {
            var term = ctx.queryParam("term");
            List<User> users;
            if (term != null) {
                users = UserRepository.search(term);
            } else {
                users = UserRepository.getEntities();
            }
            UsersPage page = new UsersPage("Список пользователей", users, term);
            ctx.contentType("text/html; charset=utf-8");
            ctx.render("pages/users.jte", model("usersPage", page));
        });

        app.get("/users/{id}", ctx -> {
            Long id = ctx.pathParamAsClass("id", Long.class).get();
            Optional<User> user = UserRepository.find(id);
            ctx.contentType("text/html; charset=utf-8");
            if (user.isEmpty()) {
                ctx.status(404).result("Пользователь не найден");
                return;
            }
            UserPage page = new UserPage("Пользователь: " + user.get().getName(), user.get());


            ctx.render("pages/user.jte", model("userPage", page));
        });

        app.start(7070);
    }
}