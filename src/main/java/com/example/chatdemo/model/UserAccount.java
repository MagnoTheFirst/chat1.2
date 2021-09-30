package com.example.chatdemo.model;

import javax.persistence.*;


@Entity
@Table
public class UserAccount {

    @Id
    @SequenceGenerator
            (
                    name="user_sequence",
                    sequenceName = "user_sequence",
                    allocationSize = 1
            )
    @GeneratedValue
            (
                    strategy = GenerationType.SEQUENCE,
                    generator = "user_sequence"
            )
    private Long id;

    private String email;
    private String password;

    public UserAccount(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public UserAccount(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserAccount() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
