package rs.ac.uns.acs.smpuos.RecipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rs.ac.uns.acs.smpuos.RecipeService.model.Category;
import rs.ac.uns.acs.smpuos.RecipeService.model.Recipe;
import rs.ac.uns.acs.smpuos.RecipeService.repository.RecipeRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class InitialData {

    private final RecipeRepository recipeRepository;

    @Autowired
    public InitialData(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

    @PostConstruct
    public void init(){
        List<Category> categories = new ArrayList<>();
        categories.add(Category.PASTA);
        Recipe r1 = new Recipe("2","Pasta Carbonara", "The most delicious carbonara you will try!", "Spaghetti, parmesan, pepper, salt, 2 eggs, ham","30 minutes",true,"/assets/carbonara.jpg",categories);
        recipeRepository.save(r1);
    }
}
