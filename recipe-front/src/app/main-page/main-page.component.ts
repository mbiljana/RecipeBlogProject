import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Role, User } from '../model/user';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {


  userRole: Role;

  constructor(private authService: UserService) {
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

}
