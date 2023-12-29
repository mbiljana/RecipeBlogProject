import { Component, Input, OnInit } from '@angular/core';
import { RecipeService } from '../recipe.service';
import { Recipe } from '../recipe';
import { HttpErrorResponse } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-all-recipes',
  templateUrl: './all-recipes.component.html',
  styleUrls: ['./all-recipes.component.css']
})
export class AllRecipesComponent implements OnInit {

  @Input()
  recipes: Recipe[] = [];

  constructor(private route: ActivatedRoute,private recipeService: RecipeService) { }



  ngOnInit(): void {
    this.loadRecipes();
  }


  public loadRecipes():void{
    this.recipeService.getRecipes().subscribe(
      res => this.recipes = res
    );
    
  }
}
