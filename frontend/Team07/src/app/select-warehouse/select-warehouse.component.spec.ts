import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectWarehouseComponent } from './select-warehouse.component';

describe('SelectWarehouseComponent', () => {
  let component: SelectWarehouseComponent;
  let fixture: ComponentFixture<SelectWarehouseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SelectWarehouseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SelectWarehouseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
