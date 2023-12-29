package rs.ac.uns.acs.smpuos.RecipeService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import rs.ac.uns.acs.smpuos.RecipeService.model.Recipe;

public interface RecipeRepository extends MongoRepository<Recipe,String> {


}
