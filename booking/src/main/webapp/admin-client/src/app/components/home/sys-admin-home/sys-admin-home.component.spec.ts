import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SysAdminHomeComponent } from './sys-admin-home.component';

describe('SysAdminHomeComponent', () => {
  let component: SysAdminHomeComponent;
  let fixture: ComponentFixture<SysAdminHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SysAdminHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SysAdminHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
