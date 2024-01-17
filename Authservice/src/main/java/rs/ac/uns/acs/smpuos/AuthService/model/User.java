package rs.ac.uns.acs.smpuos.AuthService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.lang.invoke.VarHandle;
import java.util.List;

@Document(collection = "users")
public class User {
    @Id
    private String id;

    @Field(value = "username")
    private String username;

    @Field(value = "password")
    private String password;

    @Field(value = "role")
    private Role role;

    @Field(value = "name")
    private String name;

    @Field(value = "surname")
    private String surname;

    @Field(value = "email")
    private String email;

    @Field(value = "phone")
    private String phone;

    @Field(value = "picture")
    private String picture;



    public User() {
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public User(String username, String password, Role role, String name, String surname, String email, String phone, String picture) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.picture = picture;
    }

    public User(String username, String password, Role role, String name, String surname, String email, String phone) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
