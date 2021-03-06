import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindHotelsComponent } from './find-hotels.component';

describe('FindHotelsComponent', () => {
  let component: FindHotelsComponent;
  let fixture: ComponentFixture<FindHotelsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindHotelsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindHotelsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
