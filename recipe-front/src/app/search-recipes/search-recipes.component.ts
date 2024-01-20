import { Component, OnInit } from '@angular/core';
import { Recipe, RecipeCategory } from '../recipe';
import { RecipeService } from '../recipe.service';
import { searchRecipe } from '../model/searchRecipe';

@Component({
  selector: 'app-search-recipes',
  templateUrl: './search-recipes.component.html',
  styleUrls: ['./search-recipes.component.css']
})
export class SearchRecipesComponent implements OnInit {

  name: string;
  recipes: Recipe[];
  selectedCategory: RecipeCategory | undefined;
  categories: RecipeCategory[];

  constructor(private recipeService: RecipeService) {
    this.name = '';
    this.categories = Object.values(RecipeCategory);
  }

  ngOnInit(): void {
  }

  searchRecipe(): void {
    const searchRecipe: searchRecipe = {
      name: this.name,
      category: this.selectedCategory
    };

    this.recipeService.searchRecipe(searchRecipe).subscribe(res => {
      this.recipes = res;
    });
  }
  searchRecipeCategory(): void {
    const searchRecipe: searchRecipe = {
      name: this.name,
      category: this.selectedCategory
    };
  
    this.recipeService.searchByCategory(searchRecipe.category).subscribe(
      res => {
        this.recipes = res;
      },
      error => {
        console.error('Error during search:', error);
        // Handle the error appropriately, e.g., show a user-friendly message
      }
    );
  }

}

