package rs.ac.uns.acs.smpuos.RecipeService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.acs.smpuos.RecipeService.dto.SaveRecipeRequest;
import rs.ac.uns.acs.smpuos.RecipeService.dto.SearchRecipeDTO;
import rs.ac.uns.acs.smpuos.RecipeService.model.Category;
import rs.ac.uns.acs.smpuos.RecipeService.model.Recipe;
import rs.ac.uns.acs.smpuos.RecipeService.model.User;
import rs.ac.uns.acs.smpuos.RecipeService.service.IRecipeService;
import rs.ac.uns.acs.smpuos.RecipeService.service.IUserService;

import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
@RequestMapping(path = "/api/recipes")
@CrossOrigin("*")
public class RecipeController {

    @Autowired
    IRecipeService recipeService;

    @Autowired
    IUserService userService;


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



    @GetMapping("/logged-user")
    public ResponseEntity<User> getLoggedUser(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createRecipe(@RequestBody SaveRecipeRequest saveRecipeRequest) {
        User loggedInUser = saveRecipeRequest.getUser();
        Recipe createRec = saveRecipeRequest.getRecipe();


        User user = new User();
        user.setUsername(loggedInUser.getUsername());
        user.setPassword(loggedInUser.getPassword());
        user.setId(loggedInUser.getId());
        user.setRole(loggedInUser.getRole());
        System.out.println("Logged-in User: " + user);

        Recipe recipe = new Recipe();
        recipe.setId(createRec.getId());
        recipe.setName(createRec.getName());
        recipe.setDescription(createRec.getDescription());
        recipe.setIngredients(createRec.getIngredients());
        recipe.setActive(false);
        recipe.setPrep_time(createRec.getPrep_time());
        recipe.setPicture(createRec.getPicture());
        recipe.setCategories(createRec.getCategories());
        recipe.setUser(user);

        this.recipeService.insert(recipe);
        return new ResponseEntity<Recipe>(recipe, HttpStatus.OK);
    }



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

    @RequestMapping(value = "/favourite/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<Recipe> addToFavourites(@PathVariable String id) {
        Recipe rec = userService.approveRecipe(id);
        return new ResponseEntity<>(rec, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{recipeId}")
    public ResponseEntity<?> deleteRecipe(@PathVariable String recipeId) {
        Recipe recipe = recipeService.findById(recipeId).get();
        if (recipe == null) {
            return new ResponseEntity<>("Recipe not found", HttpStatus.NOT_FOUND);
        }
        recipeService.delete(recipe);
        return new ResponseEntity<>("Recipe deleted successfully", HttpStatus.OK);
    }
}


