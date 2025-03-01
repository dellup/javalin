package org.example.hexlet.dto.controllers;

import static io.javalin.rendering.template.TemplateUtil.model;

import io.javalin.validation.ValidationException;
import org.example.hexlet.dto.NamedRoutes;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.UserRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import java.util.List;
import java.util.Optional;

public class UsersController {
    public static void index(Context ctx) {
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
    }

    public static void show(Context ctx) {
        Long id = ctx.pathParamAsClass("id", Long.class).get();
        Optional<User> user = UserRepository.find(id);
        ctx.contentType("text/html; charset=utf-8");
        if (user.isEmpty()) {
            ctx.status(404).result("Пользователь не найден");
            return;
        }
        UserPage page = new UserPage("Пользователь: " + user.get().getName(), user.get());


        ctx.render("pages/user.jte", model("userPage", page));
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