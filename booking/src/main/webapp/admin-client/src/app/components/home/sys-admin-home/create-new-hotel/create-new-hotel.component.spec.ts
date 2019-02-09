import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateNewHotelComponent } from './create-new-hotel.component';

describe('CreateNewHotelComponent', () => {
  let component: CreateNewHotelComponent;
  let fixture: ComponentFixture<CreateNewHotelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateNewHotelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateNewHotelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
