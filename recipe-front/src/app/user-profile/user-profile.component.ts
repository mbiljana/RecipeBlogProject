import { Component, OnInit } from '@angular/core';
import { UserProfile, Role } from '../model/userProfile';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  user: UserProfile;
  id: string;

  constructor(
    private route: ActivatedRoute,
    private userService: UserService
  ) {
    this.user = new UserProfile({
      id: '',
      username: '',
      role: Role.REGUSER,
      blocked: false,
      firstname: '',
      lastname: '',
      email: '',
      phone: '',
      favorites: []
    });
  }

  ngOnInit(): void {
    this.loadUser();
  }

  loadUser() {
    this.id = this.route.snapshot.params['id'];
    console.log(this.id);
    this.userService.getUser(this.id).subscribe(
      (res) => {
        this.user = res;
        this.user.id = this.id;
        console.log('User:', this.user);
      },
      (error) => {
        console.error('Error loading user:', error);
      }
    );
  }

  saveChanges() {
    this.userService.updateUser(this.user)
      .subscribe((res) => {
        this.user.authId = res.authId;
        console.log(this.user.authId);
      });
    window.location.reload();
  }

}
