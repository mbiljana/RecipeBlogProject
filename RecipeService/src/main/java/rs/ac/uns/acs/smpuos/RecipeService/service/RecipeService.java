package rs.ac.uns.acs.smpuos.RecipeService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.acs.smpuos.RecipeService.model.Recipe;
import rs.ac.uns.acs.smpuos.RecipeService.repository.RecipeRepository;

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
        return recipeRepository.findAll();
    }

    @Override
    public Recipe insert(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public void delete(Recipe recipe) {
        recipeRepository.delete(recipe);
    }
}
