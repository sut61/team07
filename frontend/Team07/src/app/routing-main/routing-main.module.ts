import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { LoginUserComponent } from '../loginuser/loginuser.component';
import { HomeComponent } from '../home/home.component';
import { RegisterComponent } from '../register/register.component';
import { RegisterShowComponent } from '../register-show/register-show.component';

import { LoginStaffComponent } from '../login-staff/login-staff.component';

import { DrugStorageMenuComponent } from '../drug-storage-menu/drug-storage-menu.component';

import { DrugdataComponent } from '../Drugdata/drugdata.component';
import { from } from 'rxjs';
import { PostComponent } from '../post/post.component';
import { ShowComponent } from '../show/show.component';
import { DeliveryShowComponent } from '../delivery-show/delivery-show.component';
import { DeliveryComponent } from '../delivery/delivery.component';

import { RedcordUseComponent } from '../redcord-use/redcord-use.component';
import { NotificationComponent } from '../notification/notification.component';

import { OrdersDrugComponent } from '../orders-drug/orders-drug.component';

import { ResistanceComponent } from '../resistance/resistance.component';
const routes: Routes = [
  //JOHN
  { path: 'login-staff', component: LoginStaffComponent },
  { path: 'drug-stroagemenu', component: DrugStorageMenuComponent },
  { path: 'orders-drug', component: OrdersDrugComponent },
  { path: 'resistance-drug', component: ResistanceComponent },
 
  


  { path: 'redcord-use', component: RedcordUseComponent },

  { path: 'home', component: HomeComponent },

  { path: '', component: LoginUserComponent },

  { path: 'register', component: RegisterComponent },
  { path: 'register-show', component: RegisterShowComponent },
   

  { path: 'drug-data', component: DrugdataComponent },

  { path: 'post', component: PostComponent },
  { path: 'show', component: ShowComponent },
  { path: 'delivery', component: DeliveryComponent },
  { path: 'delivery-show', component: DeliveryShowComponent },

  { path: 'notification', component: NotificationComponent},

];

@NgModule({
  exports: [RouterModule],
  imports: [RouterModule.forRoot(routes)]
})
export class RoutingMainModule { }
