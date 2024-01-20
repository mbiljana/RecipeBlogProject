import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient , HttpClientModule, HttpHeaders} from '@angular/common/http';
import { Role, User } from './model/user';
import { UserRecipe } from './model/userRecipe';
import { UserProfile } from './model/userProfile';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiLogin = 'http://localhost:8090/api/users/login';
  private apiSignup = 'http://localhost:8090/api/users/signup';
  private apiSave = 'http://localhost:8087/api/users/save';
  private apiLoggedUser = 'http://localhost:8090/api/users/logged-user';
  private apiUserRole = 'http://localhost:8090/api/users/user-role';
  private apiSignOut = 'http://localhost:8090/api/users/signout';
  private apiUsers = 'http://localhost:8090/api/users/get-users';
  private apiUrl = 'http://localhost:8090/api/users';
  private apiUrlUsers = 'http://localhost:8088/api/users';
  private apiUpdateProfile = 'http://localhost:8088/api/users/profile/update';
  private apiProfile = 'http://localhost:8088/api/users/profile';
  private apiAddProfile = 'http://localhost:8088/api/users/profile/save';

  constructor(private http: HttpClient) { }

  signUp(user: any): Observable<User> {
    const signUpUrl = `${this.apiSignup}`;
    return this.http.post<User>(signUpUrl, user);
  }

  save(user: any): Observable<User> {
    const saveUrl = `${this.apiSave}`;
    return this.http.post<User>(saveUrl, user);
  }

  login(credentials: any): Observable<UserRecipe> {
    const loginUrl = `${this.apiLogin}`;
    return this.http.post<UserRecipe>(loginUrl, credentials);
  }

  getLoggedUser(): Observable<User> {
    return this.http.get<User>(`${this.apiLoggedUser}`);
  }

  getUserRole(): Observable<Role> {
    return this.http.get<Role>(`${this.apiUserRole}`);
  }

  SignOut(): Observable<User> {
    return this.http.get<User>(`${this.apiSignOut}`);
  }


  getUsers(): Observable<User[]>{
    return this.http.get<User[]>(`${this.apiUsers}`);
  }

  deleteUser(userId: string): Observable<any> {
    const deleteUrl = `${this.apiUrl}/delete/${userId}`;
    return this.http.delete(deleteUrl);
  }

  updateUser(user: UserProfile): Observable<UserProfile> {
    const saveProfile = `${this.apiUpdateProfile}`;
    return this.http.post<UserProfile>(saveProfile, user);
  }

  getUser(id: string): Observable<UserProfile> {
    return this.http.get<UserProfile>(`${this.apiProfile}/${id}`);
  }

  saveProfile(user: any): Observable<UserProfile> {
    const saveProfile = `${this.apiAddProfile}`;
    return this.http.post<UserProfile>(saveProfile, user);
  }

  addFavoriteRecipe(userId: string, recipeId: string): Observable<string[]> {
    const favoritesUrl = `${this.apiUrlUsers}/${userId}/favorites?recipeId=${recipeId}`;
    return this.http.post<string[]>(favoritesUrl, null);
  }

  getFavoriteRecipes(userId: string): Observable<string[]> {
    const url = `${this.apiUrlUsers}/${userId}/favorites`;
    return this.http.get<string[]>(url);
  }
}
