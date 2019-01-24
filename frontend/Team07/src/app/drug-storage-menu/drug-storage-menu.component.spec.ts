import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DrugStorageMenuComponent } from './drug-storage-menu.component';

describe('DrugStorageMenuComponent', () => {
  let component: DrugStorageMenuComponent;
  let fixture: ComponentFixture<DrugStorageMenuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DrugStorageMenuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DrugStorageMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
