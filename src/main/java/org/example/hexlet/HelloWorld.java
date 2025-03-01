package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import io.javalin.validation.ValidationException;
import org.eclipse.jetty.server.Authentication;
import org.example.hexlet.dto.NamedRoutes;
import org.example.hexlet.dto.controllers.CoursesController;
import org.example.hexlet.dto.controllers.UsersController;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.Page;
import org.example.hexlet.dto.users.BuildUserPage;
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
        listOfCourses.forEach(CourseRepository::save);

        app.get(NamedRoutes.coursesPath(), CoursesController::index);

        app.get(NamedRoutes.coursePath("{id}"), CoursesController::show);

        app.get(NamedRoutes.buildUserPath(), UsersController::build);

        app.post(NamedRoutes.usersPath(), UsersController::create);

        app.get(NamedRoutes.usersPath(), UsersController::index);

        app.get(NamedRoutes.userPath("{id}"), UsersController::show);

        app.start(7070);
    }
}