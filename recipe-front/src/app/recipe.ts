export interface RecipeInterface {
  id?:string;
  name:string;
  description:string;
  ingredients:string;
  prep_time:string;
  active:boolean;
}

export class Recipe implements RecipeInterface{
  id?:string;
  name:string;
  description:string;
  ingredients:string;
  prep_time:string;
  active:boolean;

  constructor(obj: RecipeInterface){
    this.name = obj.name;
    this.description = obj.description;
    this.ingredients = obj.ingredients;
    this.prep_time = obj.prep_time;
    this.active = obj.active;
  }
}

