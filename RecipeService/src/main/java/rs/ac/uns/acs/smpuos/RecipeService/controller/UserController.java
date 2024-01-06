package rs.ac.uns.acs.smpuos.RecipeService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.acs.smpuos.RecipeService.model.Recipe;
import rs.ac.uns.acs.smpuos.RecipeService.service.IRecipeService;
import rs.ac.uns.acs.smpuos.RecipeService.service.IUserService;

import java.util.Optional;


@RestController
@RequestMapping(path = "/api/users")
public class UserController {


    @Autowired
    IUserService userService;
    @Autowired
    IRecipeService recipeService;

    @RequestMapping(value = "/approve/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<Recipe> approveRecipe(@PathVariable String id) {
        Recipe rec = userService.approveRecipe(id);
        return new ResponseEntity<>(rec, HttpStatus.CREATED);
    }

}
