import { Role } from "./user";

export interface UserRecipeInterface{
    id?:string;
    username: string;
    password:string;
    role: Role;
    
}
export class UserRecipe implements UserRecipeInterface{
    id?:string;
    username: string;
    password:string;
    role: Role;
   

    constructor(obj: UserRecipeInterface){
        this.username = obj.username;
        this.password = obj.password;
        this.role = obj.role;
    }
}