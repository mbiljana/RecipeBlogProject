import { Component, OnInit } from '@angular/core';
import { RecipeService } from '../recipe.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Recipe, RecipeCategory } from '../recipe';
import { Role, User } from '../model/user';
import { UserRecipe } from '../model/userRecipe';
import { UserService } from '../user.service';

@Component({
  selector: 'app-add-recipe',
  templateUrl: './add-recipe.component.html',
  styleUrls: ['./add-recipe.component.css']
})
export class AddRecipeComponent implements OnInit {

  selectedFile: File;

  constructor(private recipeService: RecipeService, private router: Router, private http: HttpClient,private userService: UserService) { 
  }

  ngOnInit(): void {
  }

  user: UserRecipe = new UserRecipe({
    username:'',
    password: '',
    role: Role.REGUSER
  });

  newRecipe: Recipe = new Recipe({
    id: '0',
    name: '',
    description: '',
    ingredients: '',
    prep_time:'',
    active: false,
    picture:'',
    user: this.user,
    categories:[]
  });

  categoryOptions: RecipeCategory[] = Object.values(RecipeCategory);
  error: string;


  /*
  addRecipe(){
    var picture_path = "/assets/" + this.selectedFile.name;
    this.newRecipe.picture = picture_path;
    this.recipeService.saveRecipe(this.newRecipe).subscribe(res =>{
      this.newRecipe =res;
    })
    this.router.navigate(['']);
  }
  */

  addRecipe() {
    var picture_path = "/assets/" + this.selectedFile.name;
    this.newRecipe.picture = picture_path;
  
    this.userService.getLoggedUser().subscribe(
      (loggedInUser) => {
        this.user.id = loggedInUser.id;
        this.user.username = loggedInUser.username;
        this.user.password = loggedInUser.password;
        this.user.role = loggedInUser.role;
        console.log(this.user.username);
        console.log(this.user.role);
        this.recipeService.saveRecipe(this.newRecipe, this.user).subscribe(
          (res) => {
            this.newRecipe = res;
            this.router.navigate(['recipes']); 
          },
          (error) => {
            console.error('Error saving recipe:', error);
          }
        );
      },
      (error) => {
        console.error('Error getting logged-in user:', error);
      }
    );
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
