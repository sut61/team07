import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { ProductWarehouseComponent } from './product-warehouse.component';
describe('ProductWarehouseComponent', () => {
  let component: ProductWarehouseComponent;
  let fixture: ComponentFixture<ProductWarehouseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductWarehouseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductWarehouseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
