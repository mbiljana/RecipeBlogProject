import { Component, OnInit } from '@angular/core';
import { Review } from '../model/review';
import { ReviewService } from '../review.service';
import { forkJoin } from 'rxjs';
import { RecipeService } from '../recipe.service';
import { ActivatedRoute } from '@angular/router';
import { RecipeCategory } from '../recipe';

@Component({
  selector: 'app-all-reviews',
  templateUrl: './all-reviews.component.html',
  styleUrls: ['./all-reviews.component.css']
})
export class AllReviewsComponent implements OnInit {
  reviews: Review[] = [];
  recipeId : string | null;

  constructor(private reviewService: ReviewService, private recipeService: RecipeService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.recipeId = this.route.snapshot.params['recipeId'];
    this.loadReviews();
  }

  loadReviews() {
    this.reviewService.getNotApprovedReviews().subscribe(
      (reviews) => {
        // Fetch recipe details for each review using forkJoin
        const observables = reviews.map(review => this.recipeService.getRecipe(review.recipe_id));

        forkJoin(observables).subscribe(
          (recipes) => {
            // Combine review and recipe information
            this.reviews = reviews.map((review, index) => {
              const recipe = recipes[index];
              return {
                ...review,
                recipeName: recipe?.name || 'N/A',
                recipeCategory: recipe?.categories || RecipeCategory.PASTA // Provide a default value
              };
            });
          },
          (error) => {
            console.error('Error fetching recipes:', error);
          }
        );
      },
      (error) => {
        console.error('Error fetching reviews:', error);
      }
    );
  }

  approveReview(id: string | any): void {
    this.reviewService.approveReview(id).subscribe(
      (response) => {
        console.log('Review approved successfully:', response);
        window.location.reload();
      },
      (error) => {
        console.error('Error approving review:', error);
        // Handle error as needed
      }
    );
  }

  rejectReview(reviewId: string | any): void {
    this.reviewService.rejectReview(reviewId).subscribe(
      (rejectedReview) => {
        console.log('Review rejected successfully:', rejectedReview);
        window.location.reload();
      },
      (error) => {
        console.error('Error rejecting review:', error);
        // Handle error as needed
      }
    );
  }

}
