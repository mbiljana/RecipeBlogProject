package rs.ac.uns.acs.smpuos.RecipeService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import rs.ac.uns.acs.smpuos.RecipeService.model.Image;

@Repository
public interface ImageRepository extends MongoRepository<Image, Long> {
}
