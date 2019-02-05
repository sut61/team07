import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { DeliveryService } from '../Service/delivery.service';
import { HttpClient } from '@angular/common/http';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';

export interface State {
  flag: string;
  name: string;
  population: string;
}

@Component({
  selector: 'app-delivery',
  templateUrl: './delivery.component.html',
  styleUrls: ['./delivery.component.css']

  
})
export class DeliveryComponent implements OnInit {
  staffs: Array<any>;
  customers: Array<any>;
  drugs: Array<any>;
  
  detail: any = {
    staff:'',
    customer:'',
    drug:'',
    amount:'',


  };
  emp: any = {
    staffSelect: '',
    customerSelect: '',
    drugSelect: ''
  };


  constructor(private router:Router,private deliveryService: DeliveryService, private httpClient: HttpClient) { }

  ngOnInit() {
    this.deliveryService.getStaffs().subscribe(data => {
      this.staffs = data;
      console.log(this.staffs);
    });
  
    this.deliveryService.getCustomers().subscribe(data => {
      this.customers = data;
      console.log(this.customers);
    });
    
    this.deliveryService.getDrugs().subscribe(data => {
    this.drugs = data;
    console.log(this.drugs);
     });
  }

  SubmitdData(){
    console.log(this.detail)
    const data  = this.detail
      this.router.navigate(['show',{
        staff:        data.staff,
        department:     data.department,
        drug:        data.drug,
      //   initial: data.initial,
      // firstname: data.firstname,
      // gender: data.gender,
      // bloodType: data.bloodType,
      // address: data.address,
      // phonenumber: data.phonenumber,
      // username: data.username,
      // password: data.password,
      
        }])
 
  }
}

