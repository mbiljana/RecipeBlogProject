export interface RecipeInterface {
  id?:string;
  name:string;
  description:string;
  ingredients:string;
  prep_time:string;
  active:boolean;
  picture:string;
}

export class Recipe implements RecipeInterface{
  id?:string;
  name:string;
  description:string;
  ingredients:string;
  prep_time:string;
  active:boolean;
  picture:string;

  constructor(obj: RecipeInterface){
    this.name = obj.name;
    this.description = obj.description;
    this.ingredients = obj.ingredients;
    this.prep_time = obj.prep_time;
    this.active = obj.active;
    this.picture = obj.picture;
  }
}

