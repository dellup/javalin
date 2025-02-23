package org.example.hexlet.dto.courses;

import lombok.Getter;
import org.example.hexlet.model.Course;

import java.util.List;


@Getter
public class CoursesPage extends Page {
    private List<Course> courses;

    public CoursesPage(String header, List<Course> courses) {
        super(header);
        this.courses = courses;

    }
}
