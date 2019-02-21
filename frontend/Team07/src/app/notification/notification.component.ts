import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from "@angular/router";
import { ActivatedRoute } from "@angular/router";

// import service
import { DrugService } from '../Service/drug.service';
import { NotificationService } from '../Service/notification.service';
import { AppserviceService } from '../Service/appservice.service';

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
  status = '';


  names: any;
  public API = '//localhost:8080';
  staffdb: any = { staffId: Number, staffName: String, staffUser: String, staffPass: String, staffPhone: String, online: String }

  setstaffOfline() {
    this.app.setStaffOfline(Number(this.staffdb.staffId)).subscribe(data => {
      console.log(data);
    })
  }


  getStaffOnline() {
    return this.http.get(this.API + '/StaffOnline/' + "true");
  }



  customer = {
    customerId: Number, customerName: String, customerPhonenumber: String,
    customerAddress: String, customerUserID: String, customerPassword: String,
    initial: { initialId: Number, name: String },
    gender: { genderId: Number, sex: String },
    bloodType: { bloodTypeId: Number, name: Number }
  };  // customer by name
  //customerselect = '';

  data: any = {}


  constructor(private app: AppserviceService,private http: HttpClient,private route: ActivatedRoute, private drugService: DrugService, private notificationservice: NotificationService, private router: Router, private httpClient: HttpClient) { }
  displayedColumns: string[] = ['position', 'customername', 'drugname', 'timeEat', 'Notification'];


  showdata() {
      console.log("data.searchCustomername = " + this.customer.customerId)

      console.log("timestartEat = " + this.data.timestartEat)
       console.log("drugselect = " + this.drugselect)

       console.log("timeEatselect = " + this.timeEatselect)
       console.log("data.timestartEat = " + this.data.timestartEat)
  }


  SaveNotification() {
    let rt = /[0-9]{1,2}\s(กุมภาพันธ์|มกราคม|มีนาคม|เมษายน|พฤษภาคม|มิถุนายน|กรกฎาคม|สิงหาคม|กันยายน|ตุลาคม|พฤษจิกายน|ธันวาคม)\s[0-9]{2,4}/g;
    if (this.status === undefined || this.status == "" || this.status == "") {
      alert("ไม่พบผู้ใช้ที่ท่านค้นหา")
        } else {
            if(rt.test(this.data.timestartEat)){
              this.notificationservice.postNotification(Number(this.customer.customerId),Number(this.drugselect),Number(this.timeEatselect),String(this.data.timestartEat)).subscribe(data=>{
              console.log(data);
              
              if (data.status == "save") {
                alert("บันทึกสำเร็จ");
                window.location.reload();
          } else {
            alert(data.status);
          }
              })
            }else{
              alert("ใส่เป็นเดือน เช่น 14 กุมภาพันธ์ 2562")
            }
          this.notificationservice.getNotificationAll().subscribe(data=>{
          this.notification = data;
          console.log(this.notification)
          })
        }
    }

  searchname() {

    if (this.data.searchCustomername === undefined || this.data.searchCustomername == "") {
      alert("กรุณาใส่ชื่อ")
    } else {
      console.log(this.data.searchCustomername)
       this.notificationservice.getCustomerByname(String(this.data.searchCustomername)).subscribe(data => {
       this.customer = data;
       if(data === null){
       this.status = null;
         alert("ไม่พบผู้ใช้")
       }else {
        alert("พบคนใช้ยาชื่อ  " +this.customer.customerName )
        this.status = "1";
       }
     })
    }

  }

  ngOnInit() {

    this.getStaffOnline().subscribe(data => {
      console.log(data);
      this.staffdb = data;
      this.names = this.staffdb.staffUser;
      console.log(this.names)
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
