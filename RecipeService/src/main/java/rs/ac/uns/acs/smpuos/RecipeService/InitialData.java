package rs.ac.uns.acs.smpuos.RecipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rs.ac.uns.acs.smpuos.RecipeService.model.Recipe;
import rs.ac.uns.acs.smpuos.RecipeService.repository.RecipeRepository;

import javax.annotation.PostConstruct;

@Component
public class InitialData {

    private final RecipeRepository recipeRepository;

    @Autowired
    public InitialData(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

    @PostConstruct
    public void init(){
        Recipe r1 = new Recipe("2","Pasta Carbonara", "The most delicious carbonara you will try!", "Spaghetti, parmesan, pepper, salt, 2 eggs, ham","30 minutes",true,"/assets/carbonara.jpg");
        recipeRepository.save(r1);
    }
}
