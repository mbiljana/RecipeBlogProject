import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Review } from '../model/review';
import { Role } from '../model/user';
import { UserProfile } from '../model/userProfile';
import { ReviewService } from '../review.service';
import { UserService } from '../user.service';
import { Location } from '@angular/common';


@Component({
  selector: 'app-add-review',
  templateUrl: './add-review.component.html',
  styleUrls: ['./add-review.component.css']
})
export class AddReviewComponent implements OnInit {
  id: any;
  username: any;
  recipeId: any;
  newReview: Review = {
    recipe_id: '',
    description: '',
    review: '',
    approved: false,
    username: ''
  };
  user: UserProfile = {
    id: '',
    username: '',
    role: Role.REGUSER,
    blocked: false,
    firstname: '',
    lastname: '',
    email: '',
    phone: '',
    favorites: []
  };

  constructor(private route: ActivatedRoute, private reviewService: ReviewService, private userService: UserService, private location: Location) { }

  ngOnInit(): void {
    this.loadUser();
  }

  loadUser() {
    this.id = this.route.snapshot.params['id'];
    console.log(this.id);
    this.userService.getUser(this.id).subscribe(
      (res) => {
        this.user = res;
        this.user.id = this.id;
        this.username = this.user.username;
        this.recipeId = this.route.snapshot.params['recipeId'];
        console.log('User:', this.user);
      },
      (error) => {
        console.error('Error loading user:', error);
      }
    );
  }

  saveChanges(): void {
    // Check if the username is available
    if (this.username) {
      // Assign the username to the newReview before saving
      this.newReview.username = this.username;
      this.newReview.recipe_id = this.recipeId;
      this.reviewService.saveReview(this.newReview).subscribe(
        (response) => {
          console.log('Review saved successfully:', response);
          this.location.back();
        },
        (error) => {
          console.error('Error saving review:', error);
          // Handle the error as needed
        }
      );
    } else {
      console.error('Username not available.');
      // Handle the situation where the username is not available
    }
    
  }
}

