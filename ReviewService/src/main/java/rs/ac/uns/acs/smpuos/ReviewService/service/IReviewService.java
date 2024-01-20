package rs.ac.uns.acs.smpuos.ReviewService.service;
import rs.ac.uns.acs.smpuos.ReviewService.model.Review;

import java.util.List;
import java.util.Optional;

public interface IReviewService {

    Review save(Review review);

    Optional<Review> findById(String id);

    List<Review> findAllByRecipeId(String recipeId);

    Review approve(String id);

    List<Review> findAllNotApprovedReviews();

    Review reject(String id);
}
