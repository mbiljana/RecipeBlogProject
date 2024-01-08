import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchRecipesViewComponent } from './search-recipes-view.component';

describe('SearchRecipesViewComponent', () => {
  let component: SearchRecipesViewComponent;
  let fixture: ComponentFixture<SearchRecipesViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchRecipesViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchRecipesViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
