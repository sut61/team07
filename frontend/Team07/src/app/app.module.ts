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



//John
import { AppserviceService } from './Service/appservice.service';
import { InputdrugstroageService } from './Service/inputdrugstroage.service';
import { OrdersService } from './Service/orders.service';
import { PartnersService } from './Service/partners.service';

import { CatalogService } from './Service/catalog.service';

// BOW

import { RegisterService } from './Service/register.service';
import { RegisterComponent } from './register/register.component';
import { RegisterShowComponent } from './register-show/register-show.component';
import { LoginStaffComponent } from './login-staff/login-staff.component';
import { DrugStorageMenuComponent } from './drug-storage-menu/drug-storage-menu.component';

//PomPam
import { PostComponent } from './post/post.component';
import { ShowComponent } from './show/show.component';
import { PostService } from './Service/post.service';
import { DeliveryService } from './Service/delivery.service';
import { DeliveryComponent } from './delivery/delivery.component';
import { DeliveryShowComponent } from './delivery-show/delivery-show.component';




import { DrugdataComponent } from './Drugdata/drugdata.component';
import { MedicineService } from './Service/medicine.service';

import { CategoryService } from './Service/category.service';
import { RedcordUseComponent } from './redcord-use/redcord-use.component';
//BOW

import { PrescriptionService } from './Service/prescription.service';
import { DrugService } from './Service/drug.service';

import { DrugdataService } from './Service/drugdata.service';
import { RedcorduseService } from './Service/redcorduse.service';
import { ResistanceService } from './Service/resistance.service';
import { NotificationComponent } from './notification/notification.component';
import { OrdersDrugComponent } from './orders-drug/orders-drug.component';
import { ResistanceComponent } from './resistance/resistance.component';
import { LoginorderComponent } from './loginorder/loginorder.component';

@NgModule({
  declarations: [
    AppComponent,LoginUserComponent,HomeComponent,
    RegisterComponent,
    RegisterShowComponent,
    LoginStaffComponent,
    DrugStorageMenuComponent,
    DrugdataComponent,
    PostComponent,
    ShowComponent,
    RedcordUseComponent,
    NotificationComponent,
    OrdersDrugComponent,
    DeliveryComponent,
    DeliveryShowComponent,
    ResistanceComponent,
    LoginorderComponent,

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
providers: [AppserviceService,CatalogService,PartnersService,OrdersService,DrugdataService,RedcorduseService,DrugService,RegisterService,MedicineService,CategoryService,InputdrugstroageService,PostService,PrescriptionService,NotificationComponent,DeliveryService],
  bootstrap: [AppComponent]
})
export class AppModule { }
