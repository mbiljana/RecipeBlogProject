package rs.ac.uns.acs.smpuos.RecipeService.service;

import rs.ac.uns.acs.smpuos.RecipeService.model.Recipe;
import rs.ac.uns.acs.smpuos.RecipeService.model.User;

import java.util.Optional;

public interface IUserService {

    Optional<User> findById(String id);

    Recipe approveRecipe(String id);
}
