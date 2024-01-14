package rs.ac.uns.acs.smpuos.RecipeService.dto;

import rs.ac.uns.acs.smpuos.RecipeService.model.Recipe;
import rs.ac.uns.acs.smpuos.RecipeService.model.User;

public class SaveRecipeRequest {
        private Recipe recipe;
        private User user;


    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
