import { Component, OnInit } from '@angular/core';
import { RecipeService } from '../recipe.service';
import { Recipe } from '../recipe';

@Component({
  selector: 'app-approve-recipe',
  templateUrl: './approve-recipe.component.html',
  styleUrls: ['./approve-recipe.component.css']
})
export class ApproveRecipeComponent implements OnInit {

  inactiveRecipes: Recipe[] = [];

  constructor(private recipeService: RecipeService) { }

  ngOnInit(): void {
    this.loadInactiveRecipes();
  }

  loadInactiveRecipes(): void {
    this.recipeService.getInactive().subscribe(
      res => this.inactiveRecipes = res,
      error => {
        // Handle error
        console.error(error);
      }
    );
  }

  approveRecipe(recipeId: string): void {
    this.recipeService.approveRecipe(recipeId).subscribe(
      () => {
        this.inactiveRecipes = this.inactiveRecipes.filter(recipe => recipe.id !== recipeId);
      },
      error => {
        // Handle error
        console.error(error);
      }
    );
  }
}

