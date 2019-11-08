import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TripsearchComponent } from './tripsearch.component';

describe('TripsearchComponent', () => {
  let component: TripsearchComponent;
  let fixture: ComponentFixture<TripsearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TripsearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TripsearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
