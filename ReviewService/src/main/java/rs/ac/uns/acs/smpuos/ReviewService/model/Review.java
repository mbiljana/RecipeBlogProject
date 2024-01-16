package rs.ac.uns.acs.smpuos.ReviewService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "reviews")
public class Review {

    @Id
    private String id;

    @Field(value = "recipe_id")
    private String recipe_id;

    @Field(value = "description")
    private String description;

    @Field(value = "review")
    private int review;

    @Field(value = "approved")
    private boolean approved;

    @Field(value = "username")
    private String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getRecipeId() {
        return recipe_id;
    }

    public void setRecipeId(String recipe_id) {
        this.recipe_id = recipe_id;
    }

    public String getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(String recipe_id) {
        this.recipe_id = recipe_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Review(String id, String recipe_id, String description, int review, boolean approved, String username) {
        this.id = id;
        this.recipe_id = recipe_id;
        this.description = description;
        this.review = review;
        this.approved = approved;
        this.username = username;
    }

    public Review() {
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Review{" +
                "id='" + id + '\'' +
                ", recipe_id='" + recipe_id + '\'' +
                ", description='" + description + '\'' +
                ", review=" + review +
                ", approved=" + approved +
                ", username='" + username + '\'' +
                '}';
    }
}