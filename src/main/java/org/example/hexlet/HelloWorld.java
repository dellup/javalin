package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;

import java.util.List;
import java.util.Objects;

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

        app.get("/courses", ctx -> {
            var term = ctx.queryParam("term");
            List<Course> courses;
            if (term != null) {
                courses = listOfCourses.stream().filter(o -> o.getDescription().contains(term)).toList();
            } else {
                courses = listOfCourses;
            }
            CoursesPage page = new CoursesPage("Список доступных курсов", courses, term);
            ctx.contentType("text/html; charset=utf-8");
            ctx.render("courses/pages/courses.jte", model("coursesPage", page));
        });

        app.get("/courses/{id}", ctx -> {
            Long id = ctx.pathParamAsClass("id", Long.class).get();
            Course course = listOfCourses.stream().filter(o -> Objects.equals(o.getId(), id)).toList().getFirst();
            CoursePage page = new CoursePage("Курс: " + course.getTitle(), course);
            ctx.contentType("text/html; charset=utf-8");

            ctx.render("courses/pages/course.jte", model("coursePage", page));
        });
        app.start(7070);
    }
}