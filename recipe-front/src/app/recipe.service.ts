import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient , HttpClientModule, HttpHeaders} from '@angular/common/http';
import { Recipe, RecipeCategory } from './recipe';
import { searchRecipe } from './model/searchRecipe';
import { HttpParams } from '@angular/common/http';
import { UserRecipe } from './model/userRecipe';



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
  private urlRecName = 'http://localhost:8087/api/recipes/search';
  private urlRecCat = 'http://localhost:8087/api/recipes';

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
  saveRecipe(recipe: Recipe, user: UserRecipe): Observable<Recipe> {
    const payload = {
      recipe: { ...recipe },
      user: { ...user }
    };
    console.log(payload);
    return this.http.post<Recipe>(this.saveUrl, payload);
  }

  //get one recipe
  getRecipe(id:string):Observable<Recipe>{
    return this.http.get<Recipe>(`${this.urlRecipe}/${id}`);
  }


  /*
  searchRecipe(sDTO: searchRecipe): Observable<Recipe[]> {
    const params = new HttpParams()
      .set('name', sDTO.name || '')
      .set('category', sDTO.category ? sDTO.category.toString() : '');
  
    const options = { params: params };
  
    return this.http.get<Recipe[]>(this.urlRecCat, options);
  }
  */

  searchRecipe(sDTO : searchRecipe):Observable<Recipe[]>{
    return this.http.post<Recipe[]>(this.urlRecName, sDTO);
  } 


  searchByCategory(categories: RecipeCategory | undefined): Observable<Recipe[]> {
    const url = `${this.urlRecCat}/search-by-category`;
    const body = { category: categories };
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  
    return this.http.post<Recipe[]>(url, JSON.stringify(body), { headers: headers });
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
