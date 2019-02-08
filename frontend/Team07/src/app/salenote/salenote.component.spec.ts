import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SalenoteComponent } from './salenote.component';

describe('SalenoteComponent', () => {
  let component: SalenoteComponent;
  let fixture: ComponentFixture<SalenoteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SalenoteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SalenoteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
