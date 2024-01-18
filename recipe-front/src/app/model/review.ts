import { RecipeCategory } from "../recipe";

export interface ReviewInterface {
  id?: string;
  recipe_id: string;
  description: string;
  review: string;
  approved: boolean;
  username: string;
  recipeName?: string;
  recipeCategory?: RecipeCategory[];

}
export class Review implements ReviewInterface {
  id?: string;
  recipe_id: string;
  description: string;
  review: string;
  approved: boolean;
  username: string;
  recipeName?: string;
  recipeCategory?: RecipeCategory[];


  constructor(obj: ReviewInterface) {
    this.id = obj.id;
    this.recipe_id = obj.recipe_id;
    this.description = obj.description;
    this.review = obj.review;
    this.approved = obj.approved;
    this.username = obj.username;
    this.recipeCategory = obj.recipeCategory;
    this.recipeName = obj.recipeName;
  }
}
