import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindRentACarServiceComponent } from './find-rent-a-car-service.component';

describe('FindRentACarServiceComponent', () => {
  let component: FindRentACarServiceComponent;
  let fixture: ComponentFixture<FindRentACarServiceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindRentACarServiceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindRentACarServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
