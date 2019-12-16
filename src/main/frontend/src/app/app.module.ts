import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { TableMobilComponent } from './table-mobil/table-mobil.component';
import { AddUpdateMobilComponent } from './add-update-mobil/add-update-mobil.component';
import {HttpClientModule} from "@angular/common/http"
import {NgbModule } from "@ng-bootstrap/ng-bootstrap";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { ToastrModule } from "ngx-toastr";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FontAwesomeModule } from "@fortawesome/angular-fontawesome";
import { ConfirmDialogComponent } from './confirm-dialog/confirm-dialog.component';
import { ConfirmDialogService} from "./confirm-dialog/confirm-dialog";

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    TableMobilComponent,
    AddUpdateMobilComponent,
    ConfirmDialogComponent,
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
      positionClass: 'toast-top-right',
      preventDuplicates: true,
    }),
    ReactiveFormsModule,
    FontAwesomeModule
  ],
  providers: [ConfirmDialogService],
  bootstrap: [AppComponent],
  entryComponents: [
    AddUpdateMobilComponent,
    ConfirmDialogComponent
  ]
})
export class AppModule { }
