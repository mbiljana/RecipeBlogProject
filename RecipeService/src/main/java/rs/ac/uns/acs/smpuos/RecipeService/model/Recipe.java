package rs.ac.uns.acs.smpuos.RecipeService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Set;

@Document(collection = "recipes")
public class Recipe {

    @Id
    private String id;

    @Field(value = "name")
    private String name;

    @Field(value = "description")
    private String description;

    @Field(value = "ingredients")
    private String ingredients;

    @Field(value = "prep_time")
    private String prep_time;

    @Field(value = "active")
    private boolean active;

    @Field(value = "picture")
    private String picture;


    @Field("user")
    private User user;
    @Field(value = "categories")
    private List<Category> categories;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getPrep_time() {
        return prep_time;
    }

    public void setPrep_time(String prep_time) {
        this.prep_time = prep_time;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Recipe() {
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Recipe(String id, String name, String description, String ingredients, String prep_time, boolean active, String picture, List<Category> categories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.prep_time = prep_time;
        this.active = active;
        this.picture = picture;
        this.categories = categories;
    }

    public Recipe(String id, String name, String description, String ingredients, String prep_time, boolean active, String picture) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.prep_time = prep_time;
        this.active = active;
        this.picture = picture;
    }

    public Recipe(String id, String name, String description, String ingredients, String prep_time, boolean active, String picture, User user, List<Category> categories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.prep_time = prep_time;
        this.active = active;
        this.picture = picture;
        this.user = user;
        this.categories = categories;
    }

    public Recipe(String name, String description, String ingredients, String prep_time, boolean active, String picture, User user, List<Category> categories) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.prep_time = prep_time;
        this.active = active;
        this.picture = picture;
        this.user = user;
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", prep_time='" + prep_time + '\'' +
                ", active=" + active +
                ", picture='" + picture + '\'' +
                ", user=" + user +
                ", categories=" + categories +
                '}';
    }
}
