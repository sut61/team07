import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { DeliveryService } from '../Service/delivery.service';
import { HttpClient } from '@angular/common/http';
import { Router } from "@angular/router";

import { StaffService } from '../Service/staff.service';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-delivery-show',
  templateUrl: './delivery-show.component.html',
  styleUrls: ['./delivery-show.component.css']
})
export class DeliveryShowComponent implements OnInit {
  data: any = {}

  public API = '//localhost:8080';
  constructor(private http: HttpClient, private route: ActivatedRoute, private staffService: StaffService, private app: DeliveryService, private router: Router, private httpClient: HttpClient) { }

  address: any;
  staffName: any;
  drugName:any;

  customerName: any;

  getCustomerById(customerId: number): Observable<any> {
    return this.http.get(this.API + '/Customer/' + customerId);
  }

  
  getAddressById(addressId :number): Observable<any> {
    return this.http.get(this.API + '/Address/' + addressId);
  }

  getDrugById(drugId :number): Observable<any> {
    return this.http.get(this.API + '/Drug/' + drugId);
  }

  ngOnInit() {

    this.route.params.subscribe(prams => {
        this.data = prams
      console.log("this. prams = " , prams)

      this.staffService.getStaffById(Number(prams.staff)).subscribe(data => {
        this.staffName = data.staffName;
        console.log("staffName get from db =   " + this.staffName);
      });


      this.getCustomerById(Number(prams.customer)).subscribe(data => {
        console.log(data)
        this.customerName = data.customerName;

      })


      this.getAddressById(Number(prams.address)).subscribe(data=>{
        console.log(data)
        this.address = data.addressName;

      })

      this.getDrugById(Number(prams.drug)).subscribe(data=>{
        console.log(data)
        this.drugName = data.name;

      })






    })


  }

}