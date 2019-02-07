import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginorderComponent } from './loginorder.component';

describe('LoginorderComponent', () => {
  let component: LoginorderComponent;
  let fixture: ComponentFixture<LoginorderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginorderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginorderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
