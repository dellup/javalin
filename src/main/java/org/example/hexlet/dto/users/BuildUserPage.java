package org.example.hexlet.dto.users;

import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.hexlet.dto.Page;

import java.util.List;
import java.util.Map;

@Getter
public class BuildUserPage extends Page {
    private String name;
    private String email;
    private String password;
    private Map<String, List<ValidationError<Object>>> errors;

    public BuildUserPage(String header, String name, String email, Map<String, List<ValidationError<Object>>> e) {
        super(header);
        this.name = name;
        this.email = email;
        this.errors = e;
    }
    public BuildUserPage() {
        super("Создание пользователей");
    }
    public BuildUserPage(String header, String name, String email, Map<String, List<ValidationError<Object>>> e, String password) {
        super(header);
        this.name = name;
        this.email = email;
        this.errors = e;
        this.password = password;
    }
}