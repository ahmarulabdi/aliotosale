import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { TableMobilComponent } from './table-mobil/table-mobil.component';
import { AddMobilComponent } from './add-mobil/add-mobil.component';
import { UpdateMobilComponent } from './update-mobil/update-mobil.component';
import {HttpClientModule} from "@angular/common/http"
import {NgbModule } from "@ng-bootstrap/ng-bootstrap";
import {FormsModule} from "@angular/forms";
import { ToastrModule } from "ngx-toastr";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    TableMobilComponent,
    AddMobilComponent,
    UpdateMobilComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    FormsModule,
    BrowserAnimationsModule, // required animations module
    ToastrModule.forRoot({
      timeOut: 5000,
      positionClass: 'toast-bottom-right',
      preventDuplicates: true,
    }),
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [
    UpdateMobilComponent
  ]
})
export class AppModule { }
