export interface UserProfileInterface {
  id?: string;
  username: string;
  authId?: string;
  role: Role;
  firstname: string;
  lastname: string;
  email: string;
  phone: string;
  blocked: boolean;
  favorites: string[];
}
export class UserProfile implements UserProfileInterface {
  id?: string;
  authId?: string;
  username: string;
  role: Role;
  firstname: string;
  lastname: string;
  email: string;
  phone: string;
  blocked: boolean;
  favorites: string[];

  constructor(obj: UserProfileInterface) {
    this.username = obj.username;
    this.role = obj.role;
    this.authId = obj.authId;
    this.firstname = obj.firstname;
    this.lastname = obj.lastname;
    this.email = obj.email;
    this.phone = obj.phone;
    this.blocked = obj.blocked;
  }
}

export enum Role {
  ADMIN = 'ADMIN',
  REGUSER = 'REGUSER',
  ANONUSER = 'ANONUSER'
}
