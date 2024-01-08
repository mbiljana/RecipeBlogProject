export interface searchRecipeInterface{
    name:string;
}

export class searchRecipe implements searchRecipeInterface{
    name: string;

    constructor(obj:searchRecipeInterface){
        this.name = obj.name;
    }
}