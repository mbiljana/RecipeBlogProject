import { User } from "./model/user";
import { UserRecipe } from "./model/userRecipe";

export interface RecipeInterface {
  id?:string;
  name:string;
  description:string;
  ingredients:string;
  prep_time:string;
  active:boolean;
  picture:string;
  user?: UserRecipe;
  categories: RecipeCategory[];
}

export class Recipe implements RecipeInterface{
  id?:string;
  name:string;
  description:string;
  ingredients:string;
  prep_time:string;
  active:boolean;
  picture:string;
  user?:UserRecipe;
  categories: RecipeCategory[];

  constructor(obj: RecipeInterface){
    this.name = obj.name;
    this.description = obj.description;
    this.ingredients = obj.ingredients;
    this.prep_time = obj.prep_time;
    this.active = obj.active;
    this.picture = obj.picture;
    this.user = obj.user;
    this.categories = obj.categories || [];
  }
}

export enum RecipeCategory {
  VEGETARIAN = 'VEGETARIAN',
  VEGAN = 'VEGAN',
  DESSERTS = 'DESSERTS',
  PASTA = 'PASTA',
  SALADS = 'SALADS',
  SOUPS = 'SOUPS'
}

