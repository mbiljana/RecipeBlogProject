export interface UserRecipeInterface{
    id?:string;
    username: string;
    password:string;
    
}
export class UserRecipe implements UserRecipeInterface{
    id?:string;
    username: string;
    password:string;
   

    constructor(obj: UserRecipeInterface){
        this.username = obj.username;
        this.password = obj.password;

    }
}