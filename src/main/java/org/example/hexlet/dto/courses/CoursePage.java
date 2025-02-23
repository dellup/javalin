package org.example.hexlet.dto.courses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.hexlet.model.Course;

import java.util.List;

@AllArgsConstructor
@Getter
public class CoursePage {
    private List<Course> courses;
    private String header;
}
