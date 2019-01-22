import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { DrugComponent } from '../drug/drug.component';
import { LoginStaffComponent } from '../login-staff/login-staff.component';

const routes: Routes = [
  {path:'',component:DrugComponent},
  {path:'Login-staff',component:LoginStaffComponent}
];

@NgModule({
 
  imports: [ RouterModule.forRoot(routes) ,CommonModule],
  declarations: []
})
export class RoutingMainModule { }
