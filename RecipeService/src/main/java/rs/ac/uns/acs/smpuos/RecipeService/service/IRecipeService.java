package rs.ac.uns.acs.smpuos.RecipeService.service;

import rs.ac.uns.acs.smpuos.RecipeService.model.Category;
import rs.ac.uns.acs.smpuos.RecipeService.model.Recipe;

import java.util.List;
import java.util.Optional;

public interface IRecipeService {

    Optional<Recipe> findById(String id);

    List<Recipe> findAll();
    List<Recipe> findInactive();

    List<Recipe> searchByTitle(String title);




    Recipe insert(Recipe recipe);

    void delete(Recipe recipe);

}
