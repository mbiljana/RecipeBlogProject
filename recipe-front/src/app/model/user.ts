export interface UserInterface{
    id?:string;
    username: string;
    password:string;
    role: Role;
    name:string;
    surname:string;
    email:string;
    phone:string;
}
export class User implements UserInterface{
    id?:string;
    username: string;
    password:string;
    role: Role;
    name:string;
    surname:string;
    email:string;
    phone:string;

    constructor(obj: UserInterface){
        this.username = obj.username;
        this.password = obj.password;
        this.role = obj.role;
        this.name = obj.name;
        this.surname = obj.surname;
        this.email = obj.email;
        this.phone = obj.phone;
    }
}

export enum Role {
    ADMIN = 'ADMIN',
    REGUSER = 'REGUSER',
    ANONUSER = 'ANONUSER'
  }