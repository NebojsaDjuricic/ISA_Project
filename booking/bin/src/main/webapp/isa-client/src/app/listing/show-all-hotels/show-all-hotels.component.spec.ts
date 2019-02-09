import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowAllHotelsComponent } from './show-all-hotels.component';

describe('ShowAllHotelsComponent', () => {
  let component: ShowAllHotelsComponent;
  let fixture: ComponentFixture<ShowAllHotelsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowAllHotelsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowAllHotelsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
