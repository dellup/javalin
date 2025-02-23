package org.example.hexlet.model;
import lombok.ToString;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@ToString
public class Course {
    private Long id;

    @ToString.Include
    private String title;
    private String description;

    public Course(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
