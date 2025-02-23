package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.model.Course;

import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        List<Course> listOfCourses = List.of(
                new Course("Курс по JS", "Лучший курс в РФ!"),
                new Course("Курс по PHP", "Лучший курс в СНГ!"),
                new Course("Курс по JAVA", "Лучший курс в СССР!")
        );

        app.get("/courses/{id}", ctx -> {
            Long id = ctx.pathParamAsClass("id", Long.class).get();
            CoursePage page = new CoursePage(listOfCourses, "Курсы");

            ctx.render("courses/index.jte", model("page", page));
        });
        app.start(7070);
    }
}