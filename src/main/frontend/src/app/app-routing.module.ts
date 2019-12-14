import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {TableMobilComponent} from "./table-mobil/table-mobil.component";


const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
