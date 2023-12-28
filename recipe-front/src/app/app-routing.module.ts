import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainPageComponent } from './main-page/main-page.component';
import { AllRecipesComponent } from './all-recipes/all-recipes.component';

const routes: Routes = [
  { path: '', component: MainPageComponent},
  { path: 'recipes', component: AllRecipesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
