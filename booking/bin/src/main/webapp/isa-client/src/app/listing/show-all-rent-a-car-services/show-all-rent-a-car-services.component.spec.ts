import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowAllRentACarServicesComponent } from './show-all-rent-a-car-services.component';

describe('ShowAllRentACarServicesComponent', () => {
  let component: ShowAllRentACarServicesComponent;
  let fixture: ComponentFixture<ShowAllRentACarServicesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowAllRentACarServicesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowAllRentACarServicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
