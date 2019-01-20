import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DrugComponent} from './drug/drug.component'
import { TypeComponent } from './type/type.component';
const routes: Routes = [
  {path:'',component:DrugComponent},
  {path:'type',component:TypeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
