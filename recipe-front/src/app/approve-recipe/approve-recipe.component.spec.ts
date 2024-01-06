import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApproveRecipeComponent } from './approve-recipe.component';

describe('ApproveRecipeComponent', () => {
  let component: ApproveRecipeComponent;
  let fixture: ComponentFixture<ApproveRecipeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApproveRecipeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ApproveRecipeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
