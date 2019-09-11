import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditRentACarServiceComponent } from './edit-rent-a-car-service.component';

describe('EditRentACarServiceComponent', () => {
  let component: EditRentACarServiceComponent;
  let fixture: ComponentFixture<EditRentACarServiceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditRentACarServiceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditRentACarServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
