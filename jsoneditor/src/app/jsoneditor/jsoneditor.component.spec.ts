import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JsoneditorComponent } from './jsoneditor.component';
import {MaterialModule} from '../core/material-module'
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NestedTreeControl} from '@angular/cdk/tree';
import {MatTreeNestedDataSource} from '@angular/material/tree';
import { By } from '@angular/platform-browser';




describe('JsoneditorComponent', () => {
  let component: JsoneditorComponent;
  let fixture: ComponentFixture<JsoneditorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JsoneditorComponent ],
      imports: [MaterialModule,BrowserAnimationsModule]

    })
    .compileComponents().then(() => {
      fixture = TestBed.createComponent(JsoneditorComponent);
      component = fixture.componentInstance;
      fixture.detectChanges();
    });
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JsoneditorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should create JsonTree', () => {
    
    component.jsonString = '{ "mani":"test"}';
    
    expect(component.showTree)

    
  
  });
  it('Handling the wrong Json', () => {
    
    component.jsonString = '{ "mani":"test";dd}';
    //component.showTree
    //const spyOnMethod = spyOn(component, 'handleError').and.callThrough()
    // act
    component.showTree
    // assert
  expect(component.showTree).toThrowError

  
  });


  it('Show tree button should have called show tree method', async(() => {



    spyOn(component, 'showTree');
    component.jsonString=' {"name":"John","age":30,"cars":{"car1":"Ford","car2":"BMW","car3":"Fiat"}}'
    fixture.detectChanges();
    
  
    let button = fixture.debugElement.nativeElement.querySelector('#showTree');
   // fixture.debugElement.query(By.css('mat-icon')).triggerEventHandler('click', {});
   button.click(); 
  
    fixture.whenStable().then(() => { 
      expect(component.showTree   ).toHaveBeenCalled();
    });
  }));


});
