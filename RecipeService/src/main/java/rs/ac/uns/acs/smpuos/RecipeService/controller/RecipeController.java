package rs.ac.uns.acs.smpuos.RecipeService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.acs.smpuos.RecipeService.model.Recipe;
import rs.ac.uns.acs.smpuos.RecipeService.service.IRecipeService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping(path = "/api/recipes")
@CrossOrigin("*")
public class RecipeController {

    @Autowired
    IRecipeService recipeService;

    @RequestMapping(value = "/get-recipe", method = RequestMethod.GET)
    public Optional<Recipe> getRecipe(
            @RequestParam(name = "id", required = true) String id) {
        return recipeService.findById(id);
    }

    @RequestMapping(value="get-one/{id}", method = RequestMethod.GET,
            produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Optional<Recipe>> findById(@PathVariable String id){
        Optional<Recipe> recipe =this.recipeService.findById(id);
        return new ResponseEntity<Optional<Recipe>>(recipe, HttpStatus.OK);
    }

    /*
    @RequestMapping(value = "/get-recipes", method = RequestMethod.GET)
    public List<Recipe> getRecipes() {

        return recipeService.findAll();
    } */

    @GetMapping(path = "/get-recipes" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Recipe>> getRecipes(){
        List<Recipe> recipes = recipeService.findAll();
        return new ResponseEntity<List<Recipe>>(recipes,HttpStatus.OK);
    }

    @GetMapping(path = "/get-inactive" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Recipe>> getInactive(){
        List<Recipe> recipes = recipeService.findInactive();
        return new ResponseEntity<List<Recipe>>(recipes,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
        Recipe addedRecipe = recipeService.insert(recipe);
        return new ResponseEntity<>(addedRecipe, HttpStatus.CREATED);
    }

    @GetMapping("/lasagne")
    public String lasagne() {
        String recipe = "LASAGNE RECIPE:";
        String prep_time = "30 minutes   ";
        String description = "Put one lasagne sheet, then bescamel souce, then tomato, then spinach.";
        recipe = recipe + prep_time + description;
        return recipe;
    }



    @PostMapping(value = "/save",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createRecipe(@RequestBody Recipe createRec) throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(createRec.getId());
        recipe.setName(createRec.getName());
        recipe.setDescription(createRec.getDescription());
        recipe.setIngredients(createRec.getIngredients());
        recipe.setActive(false);
        recipe.setPrep_time(createRec.getPrep_time());
        recipe.setPicture(createRec.getPicture());

        this.recipeService.insert(recipe);
        return new ResponseEntity<Recipe>(recipe,HttpStatus.OK);
    }


}
