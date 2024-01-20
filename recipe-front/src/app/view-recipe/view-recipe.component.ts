import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RecipeService } from '../recipe.service';
import { Recipe } from '../recipe';

@Component({
  selector: 'app-view-recipe',
  templateUrl: './view-recipe.component.html',
  styleUrls: ['./view-recipe.component.css'],
})
export class ViewRecipeComponent implements OnInit {
  recipe: Recipe;

  constructor(
    private route: ActivatedRoute,
    private recipeService: RecipeService
  ) {}

  ngOnInit(): void {
    // Use paramMap observable to handle potential changes in the route parameters
    this.route.paramMap.subscribe((params) => {
      const recipeId = params.get('id');

      if (recipeId) {
        this.recipeService.getRecipe(recipeId).subscribe(
          (res) => (this.recipe = res),
          (error) => {
            // Handle error
            console.error(error);
          }
        );
      }
    });
  }
}


