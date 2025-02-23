package org.example.hexlet.dto.courses;

import lombok.Getter;
import org.example.hexlet.model.Course;

@Getter
public class CoursePage extends Page {
    private Course course;

    public CoursePage(String header, Course course) {
        super(header);
        this.course = course;
    }
}
