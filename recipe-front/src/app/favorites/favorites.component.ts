import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserProfile } from '../model/userProfile';
import { UserService } from '../user.service';

@Component({
  selector: 'app-favorites',
  templateUrl: './favorites.component.html',
  styleUrls: ['./favorites.component.css']
})
export class FavoritesComponent implements OnInit {
  userId: any;
  favoriteRecipes: string[] = [];
  userProfile: UserProfile | undefined;

  constructor(private userService: UserService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.userId = this.route.snapshot.params['id'];
    this.loadFavoriteRecipes();
  }

  loadFavoriteRecipes(): void {
    this.userService.getFavoriteRecipes(this.userId).subscribe(
      (favorites) => {
        this.favoriteRecipes = favorites;
      },
      (error) => {
        console.error('Error fetching favorite recipes:', error);
      }
    );
  }

}
