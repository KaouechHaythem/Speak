import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActualitiesComponent } from './actualities.component';

describe('ActualitiesComponent', () => {
  let component: ActualitiesComponent;
  let fixture: ComponentFixture<ActualitiesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActualitiesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ActualitiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
