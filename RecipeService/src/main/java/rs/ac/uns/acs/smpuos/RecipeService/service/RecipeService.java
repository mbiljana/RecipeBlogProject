package rs.ac.uns.acs.smpuos.RecipeService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.acs.smpuos.RecipeService.model.Category;
import rs.ac.uns.acs.smpuos.RecipeService.model.Recipe;
import rs.ac.uns.acs.smpuos.RecipeService.repository.RecipeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService implements IRecipeService{

    @Autowired
    RecipeRepository recipeRepository;


    @Override
    public Optional<Recipe> findById(String id) {
        return recipeRepository.findById(id);
    }

    @Override
    public List<Recipe> findAll() {
        List<Recipe> recipes = recipeRepository.findAll();
        List<Recipe> activeRecipes = new ArrayList<>();
        for (Recipe r: recipes) {
            if(r.isActive() == true){
                activeRecipes.add(r);
            }
        };
        return activeRecipes;
    }

    @Override
    public List<Recipe> findInactive() {
        List<Recipe> recipes = recipeRepository.findAll();
        List<Recipe> inaciveRecipes = new ArrayList<>();
        for (Recipe r: recipes) {
            if(r.isActive() == false){
                inaciveRecipes.add(r);
            }
        };
        return inaciveRecipes;
    }

    @Override
    public List<Recipe> searchByTitle(String title) {
        List<Recipe> allRecipes = this.recipeRepository.findByName(title);
        return allRecipes;
    }




    @Override
    public Recipe insert(Recipe recipe) {
        if (recipe.getCategories() != null) {
            recipe.setCategories(new ArrayList<>(recipe.getCategories()));
        }
        return recipeRepository.save(recipe);
    }

    @Override
    public void delete(Recipe recipe) {
        recipeRepository.delete(recipe);
    }
}
