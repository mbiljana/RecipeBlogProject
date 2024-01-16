package rs.ac.uns.acs.smpuos.ReviewService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.acs.smpuos.ReviewService.model.Review;
import rs.ac.uns.acs.smpuos.ReviewService.repository.ReviewRepository;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;


@Service
public class ReviewService implements IReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public Optional<Review> findById(String id) {
        return reviewRepository.findById(id);
    }

    public List<Review> findAllByRecipeId(String recipeId) {
        List<Review> all = this.reviewRepository.findAll();
        List<Review> reviews = new ArrayList<>();
        for (Review rev : all) {
            if (rev.getRecipeId().equals(recipeId) && rev.isApproved() == true) {
                reviews.add(rev);
            }
        }
        return reviews;
    }

    public List<Review> findAllNotApprovedReviews() {
        List<Review> all = this.reviewRepository.findAll();
        List<Review> reviews = new ArrayList<>();
        for (Review rev : all) {
            if (rev.isApproved() == false) {
                reviews.add(rev);
            }
        }
        return reviews;
    }

    @Override
    public Review save(Review review) {
        return this.reviewRepository.save(review);
    }

    @Override
    public Review approve(String id) {
        Review review = this.reviewRepository.findById(id).get();
        review.setApproved(true);
        this.reviewRepository.save(review);
        return review;
    }

    @Override
    public Review reject(String id) {
        Review review = this.reviewRepository.findById(id).orElse(null);

        if (review != null) {
            review.setApproved(false);
            this.reviewRepository.delete(review);
            System.out.println("Review successfully rejected and deleted!");
            return review;
        } else {
            System.out.println("Review not found with ID: " + id);
            return null;
        }
    }
}