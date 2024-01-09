import { Recipe, RecipeCategory } from "../recipe";

export interface searchRecipeInterface{
    name:string;
    category?:RecipeCategory;
}

export class searchRecipe implements searchRecipeInterface{
    name: string;
    category?:RecipeCategory;

    constructor(obj:searchRecipeInterface){
        this.name = obj.name;
        this.category = obj.category;
    }
}