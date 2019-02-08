import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SalenoteShowComponent } from './salenote-show.component';

describe('SalenoteShowComponent', () => {
  let component: SalenoteShowComponent;
  let fixture: ComponentFixture<SalenoteShowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SalenoteShowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SalenoteShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
