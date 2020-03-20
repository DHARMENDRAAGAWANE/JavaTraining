import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TripcreateconfirmComponent } from './tripcreateconfirm.component';

describe('TripcreateconfirmComponent', () => {
  let component: TripcreateconfirmComponent;
  let fixture: ComponentFixture<TripcreateconfirmComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TripcreateconfirmComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TripcreateconfirmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
