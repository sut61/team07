import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { BillWarehouseComponent } from './bill-warehouse.component';
describe('BillWarehouseComponent', () => {
  let component: BillWarehouseComponent;
  let fixture: ComponentFixture<BillWarehouseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BillWarehouseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BillWarehouseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
