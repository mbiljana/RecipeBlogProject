// recipe.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
providedIn: 'root'
})
export class RecipeService {
private apiUrl = 'http://localhost:8080/add';

constructor(private http: HttpClient) {}

  addRecipe(recipeData: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/add`, recipeData);
  }
}

