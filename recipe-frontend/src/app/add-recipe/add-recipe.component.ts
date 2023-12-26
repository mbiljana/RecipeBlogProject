// add-recipe.component.ts
import { Component } from '@angular/core';
import { RecipeService } from '../recipe.service';

@Component({
selector: 'app-add-recipe',
templateUrl: './add-recipe.component.html',
styleUrls: ['./add-recipe.component.css']
})
export class AddRecipeComponent {
recipeData: any = {}; // Define your recipe model

constructor(private recipeService: RecipeService) {}

  addRecipe() {
    this.recipeService.addRecipe(this.recipeData).subscribe(
      response => {
        console.log('Recipe added successfully:', response);
        // Add any additional logic or navigation here
      },
      error => {
        console.error('Error adding recipe:', error);
      }
    );
  }
}

