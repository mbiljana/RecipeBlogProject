package rs.ac.uns.acs.smpuos.UserService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
public class User {

    @Id
    private String id;

    @Field(value = "authId")
    private String authId;

    @Field(value = "username")
    private String username;

    @Field(value = "firstname")
    private String firstname;

    @Field(value = "lastname")
    private String lastname;

    @Field(value = "role")
    private Role role;

    @Field(value = "email")
    private String email;

    @Field(value = "phone")
    private String phone;

    @Field(value = "blocked")
    private boolean blocked;

    @Field(value = "favorites")
    private List<String> favorites = new ArrayList<>();

    public List<String> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<String> favorites) {
        this.favorites = favorites;
    }

    public String getPhone() {
        return phone;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
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

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User(String id, String authId, String username, String firstname, String lastname, Role role, String email, String phone, boolean blocked, List<String> favorites) {
        this.id = id;
        this.authId = authId;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.email = email;
        this.phone = phone;
        this.blocked = blocked;
        this.favorites = favorites;
    }

    public User(){}

    @java.lang.Override
    public java.lang.String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", authId='" + authId + '\'' +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", role=" + role +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", blocked=" + blocked +
                ", favorites=" + favorites +
                '}';
    }
}
