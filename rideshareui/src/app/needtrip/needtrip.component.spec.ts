import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NeedtripComponent } from './needtrip.component';

describe('NeedtripComponent', () => {
  let component: NeedtripComponent;
  let fixture: ComponentFixture<NeedtripComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NeedtripComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NeedtripComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
