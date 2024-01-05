import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient , HttpClientModule, HttpHeaders} from '@angular/common/http';
import { Recipe } from './recipe';



@Injectable({
  providedIn: 'root'
})
export class RecipeService {
  private apiUrl = 'http://localhost:8087/api/recipes/get-recipes';
  private addUrl = 'http://localhost:8087/api/recipes/add';
  private saveUrl = 'http://localhost:8087/api/recipes/save';
  private urlRecipe = 'http://localhost:8087/api/recipes/get-one';

  constructor(private http: HttpClient) { }

  getRecipes(): Observable<Recipe[]>{
    return this.http.get<Recipe[]>(`${this.apiUrl}`);
  }

  
  

  public addRecipe(recipe: Recipe): Observable<Recipe>{
    return this.http.post<Recipe>(`${this.addUrl}`, recipe);
  }

  saveRecipe(recipe : Recipe):Observable<Recipe>{
    return this.http.post<Recipe>(this.saveUrl,recipe);
  }

  getRecipe(id:string):Observable<Recipe>{
    return this.http.get<Recipe>(`${this.urlRecipe}/${id}`);
  }

  /*
    public updateRecipe(recipe: Recipe): Observable<Recipe>{
    return this.http.put<Recipe>('${this.apiUrl}/update', recipe);

    public deleteRecipe(id: number): Observable<void>{
    return this.http.delete<void>('${this.apiUrl}/delete/${id}');

  }
  }
  */

}
