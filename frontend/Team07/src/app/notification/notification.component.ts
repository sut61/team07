import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from "@angular/router";
import { ActivatedRoute } from "@angular/router";

// import service 
import { DrugService } from '../Service/drug.service';
import { NotificationService } from '../Service/notification.service';

@Component({
  selector: 'app-notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.css']
})
export class NotificationComponent implements OnInit {
  // get data from db  
  drug: Array<any>;
  drugselect = '';
  notification :Array<any>;
  timeEat :Array<any>;
  timeEatselect = '';




  customer = {
    customerId: Number, customerName: String, customerPhonenumber: String,
    customerAddress: String, customerUserID: String, customerPassword: String,
    initial: { initialId: Number, name: String },
    gender: { genderId: Number, sex: String },
    bloodType: { bloodTypeId: Number, name: Number }
  };  // customer by name 
  //customerselect = '';

  data: any = {}


  constructor(private route: ActivatedRoute, private drugService: DrugService, private notificationservice: NotificationService, private router: Router, private httpClient: HttpClient) { }
  displayedColumns: string[] = ['position', 'customername', 'drugname', 'timeEat', 'Notification'];
  
  SaveNotification() {
    // console.log(this.data.symptom)
    // console.log(this.categoryselect)

    // this.notificationservice.postNotification(String(this.data.symptom), Number(this.categoryselect), Number(1), Number(this.customer.customerId)).subscribe(data => {
    //   console.log(data)
    // })



  }

  showdb() {
    console.log(this.data.namecus)
    console.log(this.drugselect)
    console.log(this.timeEatselect)
    console.log(this.data.timestartEat)
  }



  searchCustomername() {
    //  console.log(this.data.namecus)
    if (this.data.namecus === undefined || this.data.namecus == "") {
      alert("กรุณาใส่ชื่อ")
    } else {
      console.log(this.data.namecus)
      // this.redcorduseservice.getCustomerByname(String(this.data.namecus)).subscribe(data => {
      //   this.customer = data;
      // })
    }

  }

  ngOnInit() {
    this.notificationservice.getCustomerByname(String("name1")).subscribe(data => {
      this.customer = data;
      console.log(this.customer)
    })
    this.drugService.getDrug().subscribe(data => {
      this.drug = data;
      console.log(this.drug)
    })

    this.notificationservice.getNotificationAll().subscribe(data=>{
      this.notification = data;
      console.log(this.notification)
    }) 

    this.notificationservice.getTimeEatAll().subscribe(data=>{
      this.timeEat = data;
      console.log(this.timeEat)
    })



  }


}
