import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient , HttpClientModule, HttpHeaders} from '@angular/common/http';
import { User } from './model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiLogin = 'http://localhost:8090/api/users/login';
  private apiSignup = 'http://localhost:8090/api/users/signup';




  constructor(private http: HttpClient) { }

  signUp(user: any): Observable<User> {
    const signUpUrl = `${this.apiSignup}`;
    return this.http.post<User>(signUpUrl, user);
  }

  login(credentials: any): Observable<User> {
    const loginUrl = `${this.apiLogin}`;
    return this.http.post<User>(loginUrl, credentials);
  }


}
