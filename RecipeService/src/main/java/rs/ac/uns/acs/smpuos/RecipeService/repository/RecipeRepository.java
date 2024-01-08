package rs.ac.uns.acs.smpuos.RecipeService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import rs.ac.uns.acs.smpuos.RecipeService.model.Category;
import rs.ac.uns.acs.smpuos.RecipeService.model.Recipe;

import java.util.List;

public interface RecipeRepository extends MongoRepository<Recipe,String> {

    List<Recipe> findByName(String name);

}
