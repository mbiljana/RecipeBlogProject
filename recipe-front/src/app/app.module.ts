import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainPageComponent } from './main-page/main-page.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AllRecipesComponent } from './all-recipes/all-recipes.component';
import { AddRecipeComponent } from './add-recipe/add-recipe.component';
import { FormsModule } from '@angular/forms';
import { WelcomeComponent } from './welcome/welcome.component';
import { ViewRecipeComponent } from './view-recipe/view-recipe.component';
import { ApproveRecipeComponent } from './approve-recipe/approve-recipe.component';
import { SideBarComponent } from './side-bar/side-bar.component';
import { SearchRecipesComponent } from './search-recipes/search-recipes.component';
import { SearchRecipesViewComponent } from './search-recipes-view/search-recipes-view.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { BlockUsersComponent } from './block-users/block-users.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { AddReviewComponent } from './add-review/add-review.component';
import { AllReviewsComponent } from './all-reviews/all-reviews.component';
import { ReviewsComponent } from './reviews/reviews.component';
import { FavoritesComponent } from './favorites/favorites.component';

@NgModule({
  declarations: [
    AppComponent,
    MainPageComponent,
    NavbarComponent,
    AllRecipesComponent,
    AddRecipeComponent,
    WelcomeComponent,
    ViewRecipeComponent,
    ApproveRecipeComponent,
    SideBarComponent,
    SearchRecipesComponent,
    SearchRecipesViewComponent,
    SignUpComponent,
    BlockUsersComponent,
    UserProfileComponent,
    AddReviewComponent,
    AllReviewsComponent,
    ReviewsComponent,
    FavoritesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
