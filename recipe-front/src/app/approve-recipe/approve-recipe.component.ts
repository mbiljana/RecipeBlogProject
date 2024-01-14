import { Component, OnInit } from '@angular/core';
import { RecipeService } from '../recipe.service';
import { Recipe } from '../recipe';
import { Router } from '@angular/router';

@Component({
  selector: 'app-approve-recipe',
  templateUrl: './approve-recipe.component.html',
  styleUrls: ['./approve-recipe.component.css']
})
export class ApproveRecipeComponent implements OnInit {

  inactiveRecipes: Recipe[] = [];

  constructor(private recipeService: RecipeService, private router: Router) { }

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
        console.error(error);
      }
    );
  }
  onDeleteRecipe(recipeId: string): void {
    this.recipeService.deleteRecipe(recipeId).subscribe(
      () => {
        console.log('Recipe deleted successfully');
        this.router.navigate(['/approve']);
      },
      (error) => {
        console.error('Error deleting recipe:', error);
        this.router.navigate(['/approve']);
      }
    );
  }
}

