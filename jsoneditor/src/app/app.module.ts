import { BrowserModule } from '@angular/platform-browser';
import { NgModule , CUSTOM_ELEMENTS_SCHEMA} from '@angular/core';

import { AppRoutingModule } from './core/app.routing.module';
import { AppComponent } from './app.component';
import { JsoneditorComponent } from './jsoneditor/jsoneditor.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
//import {MatNativeDateModule} from '@angular/material';
import {platformBrowserDynamic} from '@angular/platform-browser-dynamic';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
//import {DemoMaterialModule} from './core/material-module';
import { XmlviewerComponent } from './xmlviewer/xmlviewer.component';



@NgModule({
  declarations: [
    AppComponent,
    JsoneditorComponent,
    XmlviewerComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
  //  DemoMaterialModule,
   // MatNativeDateModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ]
})
export class AppModule { }
