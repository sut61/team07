import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from "@angular/router";
import { ActivatedRoute } from "@angular/router";

// import service 
import { RegisterService } from '../Service/register.service';  // get initial gender bloodtype all
import { DrugService } from '../Service/drug.service';
import { NotificationService } from '../Service/notification.service';

@Component({
  selector: 'app-notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.css']
})
export class NotificationComponent implements OnInit {
   // get data from db  
   category: Array<any>;
   categoryselect = '';
   Iinitials: Array<any>;
   Initialselect = '';
   genders: Array<any>;
   genderselect = '';
   bloodtypes: Array<any>;
   bloodtypeselect = '';
 
   customer = {
     customerId: Number, customerName: String, customerPhonenumber: String,
     customerAddress: String, customerUserID: String, customerPassword: String,
     initial: { initialId: Number, name: String },
     gender: { genderId: Number, sex: String },
     bloodType: { bloodTypeId: Number, name: Number }
   };  // customer by name 
   //customerselect = '';
 
   data: any = {}
 

  constructor(private route: ActivatedRoute, private notificationservice: NotificationService, private registerservice: RegisterService, private router: Router, private httpClient: HttpClient) { }

  SaveNotification() {
    // console.log(this.data.symptom)
    // console.log(this.categoryselect)

    this.notificationservice.postNotification(String(this.data.symptom), Number(this.categoryselect), Number(1), Number(this.customer.customerId)).subscribe(data => {
      console.log(data)


    })



  }

  ngOnInit() {
    this.notificationservice.getCustomerByname(String("name1")).subscribe(data => {
      this.customer = data;
      console.log(this.customer)
    })

   
    
  }


}
