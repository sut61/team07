import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeliveryShowComponent } from './delivery-show.component';

describe('DeliveryShowComponent', () => {
  let component: DeliveryShowComponent;
  let fixture: ComponentFixture<DeliveryShowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeliveryShowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeliveryShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
