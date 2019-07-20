package com.womencancode.projetofinal.model;

import com.mongodb.lang.NonNull;
import com.womencancode.projetofinal.service.BaseModel;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Document
@Data
public class User extends BaseModel {

    private String name;
    private String lastName;
    @NonNull
    private String userName;
    @NonNull
    private String email;
    private String role;
    private LocalDate birthDate;


    @DBRef (db = "role", lazy = false)
    private Role role2;

    @Builder
    public User(String id, LocalDateTime createdDate, LocalDateTime lastModifiedDate, String name,
                String lastName, String username, String email, LocalDate birthDate, String role) {
        super(id, createdDate, lastModifiedDate);
        this.name = name;
        this.lastName = lastName;
        this.userName = username;
        this.email = email;
        this.birthDate = birthDate;
        this.role = role;
    }

}
