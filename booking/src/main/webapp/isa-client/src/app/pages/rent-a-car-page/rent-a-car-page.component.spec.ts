import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RentACarPageComponent } from './rent-a-car-page.component';

describe('RentACarPageComponent', () => {
  let component: RentACarPageComponent;
  let fixture: ComponentFixture<RentACarPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RentACarPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RentACarPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
