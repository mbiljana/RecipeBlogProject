package rs.ac.uns.acs.smpuos.RecipeService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import rs.ac.uns.acs.smpuos.RecipeService.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
