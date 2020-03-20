import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DrivertripComponent } from './drivertrip.component';

describe('DrivertripComponent', () => {
  let component: DrivertripComponent;
  let fixture: ComponentFixture<DrivertripComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DrivertripComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DrivertripComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
