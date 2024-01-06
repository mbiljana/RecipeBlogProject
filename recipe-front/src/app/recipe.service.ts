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
  private urlInactive = 'http://localhost:8087/api/recipes/get-inactive';
  private urlApprove = 'http://localhost:8087/api/users/approve';

  constructor(private http: HttpClient) { }

  //get active recipes
  getRecipes(): Observable<Recipe[]>{
    return this.http.get<Recipe[]>(`${this.apiUrl}`);
  }

  //get inactive recipes (requests)
  getInactive(): Observable<Recipe[]>{
    return this.http.get<Recipe[]>(`${this.urlInactive}`);
  }

  //approve recipes
  approveRecipe(id:string):Observable<Recipe>{
    return this.http.get<Recipe>(`${this.urlApprove}/${id}`);
  }
  
  //add new recipe
  public addRecipe(recipe: Recipe): Observable<Recipe>{
    return this.http.post<Recipe>(`${this.addUrl}`, recipe);
  }

  //save new recipe
  saveRecipe(recipe : Recipe):Observable<Recipe>{
    return this.http.post<Recipe>(this.saveUrl,recipe);
  }

  //get one recipe
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
