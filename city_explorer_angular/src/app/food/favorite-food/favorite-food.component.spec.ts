import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FavoriteFoodComponent } from './favorite-food.component';

describe('FavoriteFoodComponent', () => {
  let component: FavoriteFoodComponent;
  let fixture: ComponentFixture<FavoriteFoodComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [FavoriteFoodComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FavoriteFoodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
