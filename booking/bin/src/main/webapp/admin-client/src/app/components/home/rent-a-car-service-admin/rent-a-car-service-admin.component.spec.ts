import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RentACarServiceAdminComponent } from './rent-a-car-service-admin.component';

describe('RentACarServiceAdminComponent', () => {
  let component: RentACarServiceAdminComponent;
  let fixture: ComponentFixture<RentACarServiceAdminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RentACarServiceAdminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RentACarServiceAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
