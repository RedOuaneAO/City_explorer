import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FavoriteHotelsComponent } from './favorite-hotels.component';

describe('FavoriteHotelsComponent', () => {
  let component: FavoriteHotelsComponent;
  let fixture: ComponentFixture<FavoriteHotelsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [FavoriteHotelsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FavoriteHotelsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
