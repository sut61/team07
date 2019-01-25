import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DrugdataComponent } from './drugdata.component';
import { HttpClient } from '@angular/common/http';
describe('DrugdataComponent', () => {
  let component: DrugdataComponent;
  let fixture: ComponentFixture<DrugdataComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DrugdataComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DrugdataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
