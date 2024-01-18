import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Review } from './model/review';
import { UserRecipe } from './model/userRecipe';
import { UserProfile } from './model/userProfile';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  private apiSaveReview = 'http://localhost:8089/api/reviews/add';
  private apiBase = 'http://localhost:8089/api/reviews';

  constructor(private http: HttpClient) { }

  //save new recipe
  saveReview(review: any): Observable<Review> {
    const saveReview = `${this.apiSaveReview}`;
    return this.http.post<Review>(saveReview, review);
  }

  findAllByRecipeId(recipeId: string): Observable<Review[]> {
    const url = `${this.apiBase}/recipe/${recipeId}`;
    return this.http.get<Review[]>(url);
  }

  getNotApprovedReviews(): Observable<Review[]> {
    const endpoint = `${this.apiBase}/not-approved`;
    return this.http.get<Review[]>(endpoint);
  }

  approveReview(id: string): Observable<Review> {
    const approveReviewUrl = `${this.apiBase}/approve/${id}`;
    return this.http.post<Review>(approveReviewUrl, {});
  }

  rejectReview(reviewId: string): Observable<Review> {
    const rejectUrl = `${this.apiBase}/reject/${reviewId}`;
    return this.http.post<Review>(rejectUrl, null);
  }


}
