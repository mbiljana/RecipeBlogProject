import { Component, OnInit } from '@angular/core';
import { RecipeService } from '../recipe.service';
import { Role } from '../model/user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { SharedService } from '../shared.service';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  id: any;
  userRole: Role;

  constructor(private authService: UserService, public recipeService: RecipeService, private router: Router, private route: ActivatedRoute, private sharedService: SharedService) {
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

  profile() {
    this.sharedService.currentUserId.subscribe(id => {
      this.id = id;
      this.router.navigate(['/recipes', this.id, 'profile']);
    });
  }

  recipes() {
    this.sharedService.currentUserId.subscribe(id => {
      this.id = id;
      this.router.navigate(['/recipes', this.id]);
    });
  }

  homepage() {
    this.sharedService.currentUserId.subscribe(id => {
      this.id = id;
      this.router.navigate([this.id]);
    });
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
