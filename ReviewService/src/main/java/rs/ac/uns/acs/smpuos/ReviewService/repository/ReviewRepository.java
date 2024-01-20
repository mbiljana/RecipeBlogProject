package rs.ac.uns.acs.smpuos.ReviewService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import rs.ac.uns.acs.smpuos.ReviewService.model.Review;

public interface ReviewRepository extends MongoRepository<Review, String> {
}
