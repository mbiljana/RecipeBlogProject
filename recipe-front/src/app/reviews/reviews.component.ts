import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Review } from '../model/review';
import { ReviewService } from '../review.service';

@Component({
  selector: 'app-reviews',
  templateUrl: './reviews.component.html',
  styleUrls: ['./reviews.component.css']
})
export class ReviewsComponent implements OnInit {

  reviews: Review[] = [];

  constructor(
    private route: ActivatedRoute,
    private reviewService: ReviewService
  ) { }

  ngOnInit(): void {
    this.loadReviews();
  }

  loadReviews(): void {
    const recipeId = this.route.snapshot.params['recipeId'];
    console.log(recipeId);
    this.reviewService.findAllByRecipeId(recipeId).subscribe(
      (reviews) => {
        this.reviews = reviews;
      },
      (error) => {
        console.error('Error fetching reviews:', error);
      }
    );
  }

}
