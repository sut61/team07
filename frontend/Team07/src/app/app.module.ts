import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatCheckboxModule, MatNativeDateModule} from '@angular/material';
import {MatButtonModule} from '@angular/material';
import {MatInputModule} from '@angular/material/input';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatRadioModule} from '@angular/material/radio';
import {MatSelectModule} from '@angular/material/select';
import {MatSliderModule} from '@angular/material/slider';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatMenuModule} from '@angular/material/menu';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatListModule} from '@angular/material/list';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatCardModule} from '@angular/material/card';
import {MatStepperModule} from '@angular/material/stepper';
import {MatTabsModule} from '@angular/material/tabs';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import {MatChipsModule} from '@angular/material/chips';
import {MatIconModule} from '@angular/material/icon';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatDialogModule} from '@angular/material/dialog';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatTableModule} from '@angular/material/table';
import {MatSortModule} from '@angular/material/sort';
import {MatPaginatorModule} from '@angular/material/paginator';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { RoutingMainModule } from "./routing-main/routing-main.module";

// PEAK
import { LoginUserComponent } from './loginuser/loginuser.component';
import { HomeComponent } from './home/home.component';


//PEAK

//John
import { BillWarehouseComponent } from './bill-warehouse/bill-warehouse.component';
import { SelectWarehouseComponent } from './select-warehouse/select-warehouse.component';
import { ProductWarehouseComponent } from './product-warehouse/product-warehouse.component';
import { BillOfladingService } from './Service/bill-oflading.service';
import { ProductService } from './Service/product.service';
import { AppserviceService } from './Service/appservice.service';


// BOW

import { RegisterComponent } from './register/register.component';
import { RegisterShowComponent } from './register-show/register-show.component';
import { LoginStaffComponent } from './login-staff/login-staff.component';
import { DrugStorageMenuComponent } from './drug-storage-menu/drug-storage-menu.component';
//BOW


@NgModule({
  declarations: [
    AppComponent,LoginUserComponent,HomeComponent,
    BillWarehouseComponent,ProductWarehouseComponent,SelectWarehouseComponent,
    RegisterComponent,
    RegisterShowComponent,
    LoginStaffComponent,
    DrugStorageMenuComponent
  ],
  imports: [
    RoutingMainModule,
    HttpClientModule,
    BrowserModule,
    BrowserAnimationsModule,
    MatCheckboxModule,
    MatCheckboxModule,
    MatButtonModule,
    MatInputModule,
    MatAutocompleteModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatRadioModule,
    MatSelectModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatMenuModule,
    MatSidenavModule,
    MatToolbarModule,
    MatListModule,
    MatGridListModule,
    MatCardModule,
    MatStepperModule,
    MatTabsModule,
    MatExpansionModule,
    MatButtonToggleModule,
    MatChipsModule,
    MatIconModule,
    MatProgressSpinnerModule,
    MatProgressBarModule,
    MatDialogModule,
    MatTooltipModule,
    MatSnackBarModule,
    MatTableModule,
    MatSortModule,
    MatPaginatorModule,
    MatNativeDateModule,
    FormsModule,





  ],
  providers: [BillOfladingService,ProductService,AppserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
