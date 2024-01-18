import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainPageComponent } from './main-page/main-page.component';
import { AllRecipesComponent } from './all-recipes/all-recipes.component';
import { AddRecipeComponent } from './add-recipe/add-recipe.component';
import { ViewRecipeComponent } from './view-recipe/view-recipe.component';
import { ApproveRecipeComponent } from './approve-recipe/approve-recipe.component';
import { SearchRecipesComponent } from './search-recipes/search-recipes.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { BlockUsersComponent } from './block-users/block-users.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AddReviewComponent } from './add-review/add-review.component';
import { AllReviewsComponent } from './all-reviews/all-reviews.component';
import { ReviewsComponent } from './reviews/reviews.component';
import { FavoritesComponent } from './favorites/favorites.component';

const routes: Routes = [
  { path: '', component: MainPageComponent},
  { path: 'recipes/:id', component: AllRecipesComponent },
  { path: 'recipes/:id/favorites', component: FavoritesComponent },
  { path: 'recipes/:id/add-review/:recipeId', component: AddReviewComponent },
  { path: 'recipes/:id/review/:recipeId', component: ReviewsComponent },
  { path: 'reviews', component: AllReviewsComponent },
  { path: 'add-recipe', component: AddRecipeComponent},
  { path: 'recipe/:id', component: ViewRecipeComponent},
  { path: 'approve', component: ApproveRecipeComponent},
  { path: 'search', component: SearchRecipesComponent},
  { path: 'login-signup', component: SignUpComponent},
  { path: 'block-users', component: BlockUsersComponent },
  { path: 'recipes/:id/profile', component: UserProfileComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
