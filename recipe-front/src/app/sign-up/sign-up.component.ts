import { Component, OnInit } from '@angular/core';
import { Role, User } from '../model/user';
import { UserProfile } from '../model/userProfile';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { waitForAsync } from '@angular/core/testing';

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


  async signUp() {
    try {
      // Assuming this.userService.signUp returns an Observable<User>
      this.userService.signUp(this.signUpCredentials)
        .subscribe(async (user) => {
          // Save the user profile after successful signup
          const userProfile: UserProfile = {
            authId : user.id,
            username: user.username,
            role: user.role,
            firstname: user.name,
            lastname: user.surname,
            email: user.email,
            phone: user.phone,
            blocked: false,
            favorites: [],
          };

          // Assuming this.userService.saveProfile returns a Promise<any>
          await this.userService.saveProfile(userProfile).toPromise();
          console.log(userProfile);

          // Successfully signed up and saved profile
          this.showLoginForm();
        },
          (error) => {
            if (error.status === 403) {
              // User is blocked
              this.showBlockedMessage();
            } else {
              // Handle other login errors
              console.error('Login error:', error);
            }
          });
    } catch (error) {
      // Handle other errors if needed
      console.error('Error during signup:', error);
    }
  }

  login() {
    this.userService.login(this.loginCredentials).subscribe(
      (user) => {
        const userIdFromResponse = user.id;
        this.router.navigate(['/recipes', userIdFromResponse]);
      },
      (error) => {
        if (error.status === 403) {
            // User is blocked
            this.showBlockedMessage();
        } else {
            // Handle other login errors
            console.error('Login error:', error);
        }
    }
    );
  }


  showBlockedMessage() {
    // Implement logic to display a blocked user message on the front end
    alert('Sorry, you are blocked. Please contact support for assistance.');
}

  

  showLoginForm() {
    this.showLogin = true;
    this.showSignUp = false;
  }

  showSignUpForm() {
    this.showLogin = false;
    this.showSignUp = true;
  }

  reloadPage(){
    window.location.reload();
  }

}
