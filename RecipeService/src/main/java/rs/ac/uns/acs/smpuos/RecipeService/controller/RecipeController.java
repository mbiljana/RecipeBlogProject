package rs.ac.uns.acs.smpuos.RecipeService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.acs.smpuos.RecipeService.dto.SearchRecipeDTO;
import rs.ac.uns.acs.smpuos.RecipeService.model.Category;
import rs.ac.uns.acs.smpuos.RecipeService.model.Recipe;
import rs.ac.uns.acs.smpuos.RecipeService.service.IRecipeService;

import java.util.*;

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
        recipe.setCategories(createRec.getCategories());

        this.recipeService.insert(recipe);
        return new ResponseEntity<Recipe>(recipe,HttpStatus.OK);
    }

    /*
    @GetMapping("/search-by-category")
    public ResponseEntity<List<Recipe>> searchByCategory(
            @RequestParam(name = "category") Category category) {
        List<Recipe> recipes = recipeService.searchByCategory(category);
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    } */


    @RequestMapping(value="/search", method = RequestMethod.POST,
            produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Recipe>> findAllRecipesWithName(@RequestBody SearchRecipeDTO searchRecipeDTO){
        List<Recipe> recipes=this.recipeService.searchByTitle(searchRecipeDTO.getName());
        return new ResponseEntity<List<Recipe>>(recipes, HttpStatus.OK);
    }


    @PostMapping("/search-by-category")
    public ResponseEntity<List<Recipe>> searchByCategory(@RequestBody Map<String, String> payload) {
        String categoryString = payload.get("category");
        Category category = Category.valueOf(categoryString);
        List<Recipe> recipes = recipeService.searchByCategory(category);
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    /*
    @GetMapping("/search")
    public ResponseEntity<List<Recipe>> searchRecipes(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "category", required = false) String categoryString) {

        // Convert the string to the Category enum
        Category category;
        try {
            category = (categoryString != null) ? Category.valueOf(categoryString) : null;
        } catch (IllegalArgumentException e) {
            // Log if the conversion fails
            System.out.println("Error converting categoryString to Category enum: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // Call the updated service method with the converted parameters
        List<Recipe> recipes = recipeService.searchRecipes(name, category);

        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }
    */

}
