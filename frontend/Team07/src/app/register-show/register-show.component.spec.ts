import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterShowComponent } from './register-show.component';

describe('RegisterShowComponent', () => {
  let component: RegisterShowComponent;
  let fixture: ComponentFixture<RegisterShowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterShowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
