import { Component, EventEmitter, Output,OnInit } from '@angular/core';

@Component({
  selector: 'app-side-bar',
  templateUrl: './side-bar.component.html',
  styleUrls: ['./side-bar.component.css']
})
export class SideBarComponent {

  categories: string[] = ['Vegetarian', 'Vegan', 'Desserts', 'Pasta', 'Salads', 'Soups'];
  isOpen: boolean = true;

  @Output() categorySelected = new EventEmitter<string>();

  searchRecipesByCategory(category: string): void {
    this.categorySelected.emit(category);
  }

  toggleSidebar(): void {
    this.isOpen = !this.isOpen;
  }

}
