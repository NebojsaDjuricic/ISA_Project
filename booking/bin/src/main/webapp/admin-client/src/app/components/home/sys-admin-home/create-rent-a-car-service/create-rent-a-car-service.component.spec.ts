import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateRentACarServiceComponent } from './create-rent-a-car-service.component';

describe('CreateRentACarServiceComponent', () => {
  let component: CreateRentACarServiceComponent;
  let fixture: ComponentFixture<CreateRentACarServiceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateRentACarServiceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateRentACarServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
