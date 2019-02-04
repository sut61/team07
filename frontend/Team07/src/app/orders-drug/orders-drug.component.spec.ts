import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrdersDrugComponent } from './orders-drug.component';

describe('OrdersDrugComponent', () => {
  let component: OrdersDrugComponent;
  let fixture: ComponentFixture<OrdersDrugComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrdersDrugComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrdersDrugComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
