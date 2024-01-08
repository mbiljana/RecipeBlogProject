import { Component, OnInit } from '@angular/core';
import { Recipe } from '../recipe';
import { RecipeService } from '../recipe.service';

@Component({
  selector: 'app-search-recipes',
  templateUrl: './search-recipes.component.html',
  styleUrls: ['./search-recipes.component.css']
})
export class SearchRecipesComponent implements OnInit {

  name: string;
  recipes: Recipe[];

  constructor(private recipeService: RecipeService) {
    this.name = '';
  }

  ngOnInit(): void {
  }

  searchRecipe(): void {
    this.recipeService.searchRecipe({ name: this.name }).subscribe(res => {
      this.recipes = res;
    });
  }
}

