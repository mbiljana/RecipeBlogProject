package rs.ac.uns.acs.smpuos.ReviewService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.acs.smpuos.ReviewService.service.IReviewService;
import rs.ac.uns.acs.smpuos.ReviewService.model.Review;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/reviews")
@CrossOrigin("*")
public class ReviewController {

    @Autowired
    IReviewService reviewService;

    @PostMapping("/add")
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        Review addedReview = reviewService.save(review);
        return new ResponseEntity<>(addedReview, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Optional<Review> findOne(@PathVariable String id){
        return reviewService.findById(id);
    }

    @RequestMapping(value="/recipe/{recipeId}", method = RequestMethod.GET,
            produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Review>> findAllByRecipeId(@PathVariable String recipeId){
        List<Review> reviews=this.reviewService.findAllByRecipeId(recipeId);
        return new ResponseEntity<List<Review>>(reviews, HttpStatus.OK);
    }

    //Admin approving user comment
    @RequestMapping(value = "/approve/{id}", method = RequestMethod.POST)
    public ResponseEntity<Review> approveReview(@PathVariable String id) {
        Review review = this.reviewService.approve(id);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/reject/{id}", method = RequestMethod.POST)
    public ResponseEntity<Review> rejectReview(@PathVariable String id) {
        Review review = this.reviewService.reject(id);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    //Get all not approved reviews
    @RequestMapping(value="/not-approved", method = RequestMethod.GET,
            produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Review>> approvedReviews(){
        List<Review> reviews=this.reviewService.findAllNotApprovedReviews();
        return new ResponseEntity<List<Review>>(reviews, HttpStatus.OK);
    }
}
