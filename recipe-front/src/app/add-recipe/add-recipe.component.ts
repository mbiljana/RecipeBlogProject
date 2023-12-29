import { Component, OnInit } from '@angular/core';
import { RecipeService } from '../recipe.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Recipe } from '../recipe';

@Component({
  selector: 'app-add-recipe',
  templateUrl: './add-recipe.component.html',
  styleUrls: ['./add-recipe.component.css']
})
export class AddRecipeComponent implements OnInit {

  selectedFile: File;

  constructor(private recipeService: RecipeService, private router: Router, private http: HttpClient) { 
  }

  ngOnInit(): void {
  }

  newRecipe: Recipe = new Recipe({
    id: '0',
    name: '',
    description: '',
    ingredients: '',
    prep_time:'',
    active: false,
    picture:''
  });

  error: string;


  addRecipe(){
    var picture_path = "/assets/" + this.selectedFile.name;
    this.newRecipe.picture = picture_path;
    this.recipeService.saveRecipe(this.newRecipe).subscribe(res =>{
      this.newRecipe =res;
    })
    this.router.navigate(['']);
  }

  onUpload() {
    console.log(this.selectedFile);

    //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
    const uploadImageData = new FormData();
    uploadImageData.append('file', this.selectedFile, this.selectedFile.name);
    this.newRecipe.picture = this.selectedFile.name;
    this.http.post('http://localhost:8087/upload', uploadImageData)
      .subscribe((response) => {
        }
      );
  }

  public onFileChanged(event: any) {
    this.selectedFile = event.target.files[0];
  }

}
