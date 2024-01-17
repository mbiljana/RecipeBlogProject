import { Component, OnInit } from '@angular/core';
import { RecipeService } from '../recipe.service';
import { Role } from '../model/user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {


  userRole: Role;

  constructor(private authService: UserService,public recipeService: RecipeService,private router: Router) {
    this.authService.getUserRole().subscribe(
      (role: Role) => {
        this.userRole = role;
      },
      (error) => {
        console.error('Error getting user role:', error);
      }
    );
  }
  ngOnInit(): void {
  }

  signout() {
    this.authService.SignOut().subscribe(
      (user) => {
        this.router.navigate(['']);
      },
      (error) => {
        console.error('Signout error:', error);
      }
    );
  }

  reloadPage(){
    window.location.reload();
  }

}
