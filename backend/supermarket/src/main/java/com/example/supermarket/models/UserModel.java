package com.example.supermarket.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Users")
public class UserModel {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String firstname;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String role;

    public UserModel(String firstname, String phone, String email, String password, String role) {
        this.firstname = firstname;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
