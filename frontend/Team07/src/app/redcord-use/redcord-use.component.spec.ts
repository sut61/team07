import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RedcordUseComponent } from './redcord-use.component';

describe('RedcordUseComponent', () => {
  let component: RedcordUseComponent;
  let fixture: ComponentFixture<RedcordUseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RedcordUseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RedcordUseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
