import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainPageComponent } from './main-page/main-page.component';
import { AllRecipesComponent } from './all-recipes/all-recipes.component';
import { AddRecipeComponent } from './add-recipe/add-recipe.component';
import { ViewRecipeComponent } from './view-recipe/view-recipe.component';
import { ApproveRecipeComponent } from './approve-recipe/approve-recipe.component';
import { SearchRecipesComponent } from './search-recipes/search-recipes.component';
import { SignUpComponent } from './sign-up/sign-up.component';

const routes: Routes = [
  { path: '', component: MainPageComponent},
  { path: 'recipes', component: AllRecipesComponent},
  { path: 'add-recipe', component: AddRecipeComponent},
  { path: 'recipe/:id', component: ViewRecipeComponent},
  { path: 'approve', component: ApproveRecipeComponent},
  { path: 'search', component: SearchRecipesComponent},
  { path: 'login-signup', component: SignUpComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
