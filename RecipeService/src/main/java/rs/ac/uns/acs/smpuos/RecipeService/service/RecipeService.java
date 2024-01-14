package rs.ac.uns.acs.smpuos.RecipeService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.acs.smpuos.RecipeService.model.Category;
import rs.ac.uns.acs.smpuos.RecipeService.model.Recipe;
import rs.ac.uns.acs.smpuos.RecipeService.model.User;
import rs.ac.uns.acs.smpuos.RecipeService.repository.RecipeRepository;
import rs.ac.uns.acs.smpuos.RecipeService.repository.UserRepository;

import java.util.*;

@Service
public class RecipeService implements IRecipeService{

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    IUserService userService;

    @Autowired
    UserRepository userRepository;


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
    public List<Recipe> searchByCategory(Category category) {
        return recipeRepository.findByCategoriesIn(category);
    }


    /*
    public List<Recipe> searchRecipes(String name, Category category) {
        if (name != null && category != null) {
            return recipeRepository.findByNameAndCategoriesIn(name, category);
        } else if (name != null) {
            return recipeRepository.findByName(name);
        } else if (category != null) {
            return recipeRepository.findByCategoriesIn(category);
        } else {
            return recipeRepository.findAll();
        }
    } */

    @Override
    public Recipe insert(Recipe recipe) {
        if (recipe.getCategories() != null) {
            recipe.setCategories(new ArrayList<>(recipe.getCategories()) {
            });
        }

        return recipeRepository.save(recipe);
    }


    @Override
    public void delete(Recipe recipe) {
        recipeRepository.delete(recipe);
    }
}
