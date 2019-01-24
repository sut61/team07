import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { BillWarehouseComponent } from '../bill-warehouse/bill-warehouse.component';
import { ProductWarehouseComponent } from '../product-warehouse/product-warehouse.component';
import { SelectWarehouseComponent } from '../select-warehouse/select-warehouse.component';
import { LoginUserComponent } from '../loginuser/loginuser.component';
import { HomeComponent } from '../home/home.component';
import { RegisterComponent } from '../register/register.component';
import { RegisterShowComponent } from '../register-show/register-show.component';

import { LoginStaffComponent } from '../login-staff/login-staff.component';

import { DrugStorageMenuComponent } from '../drug-storage-menu/drug-storage-menu.component';
import { from } from 'rxjs';

const routes: Routes = [
  //JOHN
  { path: 'product', component: ProductWarehouseComponent },
  { path: 'select', component: SelectWarehouseComponent },
  { path: 'bill', component: BillWarehouseComponent },
  { path: 'login-staff', component: LoginStaffComponent },
  { path: 'drug-stroagemeng', component: DrugStorageMenuComponent },

  //PECK

  { path: 'select', component: SelectWarehouseComponent },
  { path: 'home', component: HomeComponent },

  { path: '', component: LoginUserComponent },

  { path: 'register', component: RegisterComponent },
  { path: 'register-show', component: RegisterShowComponent },
];

@NgModule({
  exports: [RouterModule],
  imports: [RouterModule.forRoot(routes)]
})
export class RoutingMainModule { }
