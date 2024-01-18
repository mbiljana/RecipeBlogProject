import { Component, Input, OnInit } from '@angular/core';
import { RecipeService } from '../recipe.service';
import { Recipe } from '../recipe';
import { HttpErrorResponse } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { SharedService } from '../shared.service';
import { Route } from '@angular/compiler/src/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-all-recipes',
  templateUrl: './all-recipes.component.html',
  styleUrls: ['./all-recipes.component.css']
})
export class AllRecipesComponent implements OnInit {

  id: any;
  @Input()
  recipes: Recipe[] = [];

  constructor(private route: ActivatedRoute, private recipeService: RecipeService, private sharedService: SharedService, private router: Router, private userService: UserService) { }


  ngOnInit(): void {
    this.loadRecipes();
    const id = this.route.snapshot.params['id'];
    this.sharedService.setUserId(id);
    console.log(id);
    console.log(this.sharedService.getUserId());
  }


  public loadRecipes():void{
    this.recipeService.getRecipes().subscribe(
      res => this.recipes = res

    );
    
  }

  addReview(recipeId: string | undefined): void {
    this.id = this.route.snapshot.params['id'];
    this.router.navigate(['/recipes', this.id, 'add-review', recipeId]);
  }

  getFavorites() {
    this.id = this.route.snapshot.params['id'];
    this.router.navigate(['/recipes', this.id, 'favorites']);
  }

  loadReviews(recipeId: string | undefined): void {
    this.id = this.route.snapshot.params['id'];
    this.router.navigate(['/recipes', this.id, 'review', recipeId]);
  }

  isFavorite: boolean = false;
  addFavoriteRecipe(userId: string | any, recipeId: string | any): void {
    this.userService.addFavoriteRecipe(this.id, recipeId).subscribe(
      (favorites) => {
        console.log('Recipe added to favorites successfully:', favorites);
        // Toggle the isFavorite property
        this.id
        this.isFavorite = !this.isFavorite;
      },
      (error) => {
        console.error('Error adding recipe to favorites:', error);
      }
    );
  }

}
