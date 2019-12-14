import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponentComponent } from './navbar/navbar-component.component';
import { SearchBoxComponent } from './search-box/search-box.component';
import { MainTableComponent } from './main-table/main-table.component';
import { MainTableComponentComponent } from './main-table-component/main-table-component.component';
import { TambahComponentComponent } from './tambah-component/tambah-component.component';
import { TableMobilComponentComponent } from './table-mobil/table-mobil-component.component';
import { AddMobilComponentComponent } from './add-mobil/add-mobil-component.component';
import { UpdateMobilComponentComponent } from './update-mobil/update-mobil-component.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponentComponent,
    SearchBoxComponent,
    MainTableComponent,
    MainTableComponentComponent,
    TambahComponentComponent,
    TableMobilComponentComponent,
    AddMobilComponentComponent,
    UpdateMobilComponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
