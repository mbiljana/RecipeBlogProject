import { Component, OnInit } from '@angular/core';
import { Role, User } from '../model/user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent {
  showLogin = true;
  showSignUp = false;

  saveCredentials = {
    username: '',
    password: ''
  };

  loginCredentials = {
    username: '',
    password: ''
  };

  signUpCredentials = {
    username: '',
    password: '',
    role: Role.REGUSER,
    name: '',
    surname: '',
    email: '',
    phone: ''
  };

  constructor(private userService: UserService, private router: Router) {}


  signUp() {
    this.userService.signUp(this.signUpCredentials).subscribe(
      (user) => {
        this.showLoginForm();
      },
      (error) => {
        console.error('Sign-up error:', error);
      }
    );
      this.saveCredentials.username = this.signUpCredentials.username;
      this.saveCredentials.password = this.signUpCredentials.password;
    this.userService.save(this.saveCredentials).subscribe(
    );
  }

  login() {
    this.userService.login(this.loginCredentials).subscribe(
      (user) => {
        this.router.navigate(['/recipes']);
      },
      (error) => {
        console.error('Login error:', error);
      }
    );
  }

  showLoginForm() {
    this.showLogin = true;
    this.showSignUp = false;
  }

  showSignUpForm() {
    this.showLogin = false;
    this.showSignUp = true;
  }

}
