import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { DrugComponent } from '../drug/drug.component';
import { TypeComponent } from '../type/type.component';
import { LoginStaffComponent } from '../login-staff/login-staff.component';

const routes: Routes = [
  {path:'',component:DrugComponent},
  {path:'Type',component:TypeComponent},
  {path:'Login-staff',component:LoginStaffComponent}
];

@NgModule({
  exports: [],
  imports: [ RouterModule.forRoot(routes) ]
})
export class RoutingMainModule { }
