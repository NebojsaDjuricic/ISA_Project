import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomePageForRegisteredUserComponent } from './home-page-for-registered-user.component';

describe('HomePageForRegisteredUserComponent', () => {
  let component: HomePageForRegisteredUserComponent;
  let fixture: ComponentFixture<HomePageForRegisteredUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomePageForRegisteredUserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomePageForRegisteredUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
