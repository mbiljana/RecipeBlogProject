package rs.ac.uns.acs.smpuos.RecipeService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import rs.ac.uns.acs.smpuos.RecipeService.model.Category;
import rs.ac.uns.acs.smpuos.RecipeService.model.Recipe;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface RecipeRepository extends MongoRepository<Recipe,String> {

    List<Recipe> findByName(String name);
    List<Recipe> findByCategoriesIn(Category category);

   // List<Recipe> findByNameAndCategoriesIn(String name, Category category);

}
