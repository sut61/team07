import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { DeliveryService } from '../Service/delivery.service';
import { HttpClient } from '@angular/common/http';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';

@Component({
  selector: 'app-delivery',
  templateUrl: './delivery.component.html',
  styleUrls: ['./delivery.component.css']


})
export class DeliveryComponent implements OnInit {
  staffs: Array<any>;
  customers: Array<any>;
  drugs: Array<any>;
  addresss: Array<any>;
  addressselect = '';

  detail: any = {
    staff: '',
    customer: '',
    drug: '',
    amount: '',
    netamount: '',
    //address: '',



  };
  emp: any = {
    staffSelect: '',
    customerSelect: '',
    // addressSelect: '',
    drugSelect: '',

  };

  // showdatainput() {
  //   console.log("initialId = " + this.initialselect)
  //   console.log("genderselect = " + this.genderselect)
  //   console.log("bloodTypeselect = " + this.bloodTypeselect)


  // }
  constructor(private router: Router, private deliveryService: DeliveryService, private httpClient: HttpClient) { }

  ngOnInit() {
    this.deliveryService.getStaffs().subscribe(data => {
      this.staffs = data;
      console.log(this.staffs);
    });



    this.deliveryService.getCustomers().subscribe(data => {
      this.customers = data;
      console.log(this.customers);
    });
    this.deliveryService.getAddress().subscribe(data => {
      this.addresss = data;
      console.log(this.addresss);
    });
    this.deliveryService.getDrugs().subscribe(data => {
      this.drugs = data;
      console.log(this.drugs);
    });
  }

  SubmitdData() {
    console.log(this.detail)
    const data = this.detail
    this.router.navigate(['delivery-show', {

      staff: data.staff,
      customer: data.customer,
      address: data.address,

      drug: data.drug,
      amount: data.amount,
      netamount: data.netamount,

    }])

  }
  save() {
    this.httpClient.post('http://localhost:8080/Invoice-insert/StaffId/' + this.emp.staffSelect + '/customerId/' + this.emp.customerSelect + '/addressId/' + this.addressselect + '/drugId/' + this.emp.drugSelect + '/Amount/' + String(this.detail.netamount) + '/Netamount/' + String(this.detail.netamount), this.emp)
      .subscribe(
        data => { console.log('PUT Request is successful', data); },
        error => { console.log('Error', error); }
      );
  }
}


