package org.example.hexlet.dto.courses;

import lombok.Getter;
import org.example.hexlet.model.Course;

import java.util.List;


@Getter
public class CoursesPage extends Page {
    private List<Course> courses;
    private String term;

    public CoursesPage(String header, List<Course> courses, String term) {
        super(header);
        this.courses = courses;
        this.term = term;
    }
}
