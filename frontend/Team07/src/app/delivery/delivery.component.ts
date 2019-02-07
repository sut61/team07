import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { DeliveryService } from '../Service/delivery.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-delivery',
  templateUrl: './delivery.component.html',
  styleUrls: ['./delivery.component.css']


})
export class DeliveryComponent implements OnInit {
  staffs: Array<any>;
  staffselect = '';
  customers: Array<any>;
  customerselect = '';
  addresss: Array<any>;
  addressselect = '';
  drugs: Array<any>;
  drugselect = '';
  status;
  count: 0;

  detail: any = {
    staff: '',
    customer: '',
    address: '',
    drug: '',

    amount: '',
    netamount: '',


  };
  emp: any = {
    staffSelect: '',
    customerSelect: '',
    addressSelect: '',
    drugSelect: '',

  };

  showdatainput() {
    console.log("staffselect = " + this.staffselect)
    console.log("customerselect = " + this.customerselect)
    console.log("addressselect = " + this.addressselect)
    console.log("drugselect = " + this.drugselect)




  }
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
      address: this.addressselect,

      drug: data.drug,
      amount: data.amount,
      netamount: data.netamount,

    }])

  }
  save() {
    this.detail.addressSelect = this.addressselect;

    if (this.emp.staffSelect === undefined || this.emp.staffSelect === "" || this.emp.staffSelect == null) {

      this.count = 0;
    } else {

      this.count += 1;
    }
    if (this.emp.customerSelect === undefined || this.emp.customerSelect === "" || this.emp.customerSelect == null) {

      this.count = 0;
    } else {

      this.count += 1;
    }
    if (this.emp.drugSelect === undefined || this.emp.drugSelect === "" || this.emp.drugSelect == null) {

      this.count = 0;
    } else {
      this.count += 1;
    }
    if (this.addressselect === undefined || this.addressselect === "" || this.addressselect == null) {

      this.count = 0;
    } else {
      this.count += 1;
    }

    if (this.addressselect === undefined || this.addressselect === "" || this.addressselect == null) {

      this.count = 0;
    } else {
      this.count += 1;
    }
    
    if (this.detail.amount === undefined || this.detail.amount === "" || this.detail.amount == null) {

      this.count = 0;
    } else {
      this.count += 1;
    }
    if (this.detail.netamount === undefined || this.detail.netamount === "" || this.detail.netamount == null) {

      this.count = 0;
    } else {
      this.count += 1;
    }


    if(this.count >=6){ 
      //
      this.detail.addressSelect = this.addressselect;
      this.httpClient.post('http://localhost:8080/Invoice-insert/StaffId/' + this.emp.staffSelect + '/customerId/' + this.emp.customerSelect + '/addressId/' + this.addressselect + '/drugId/' + this.emp.drugSelect + '/Amount/' + String(this.detail.amount) + '/Netamount/' + String(this.detail.netamount), this.emp)
        .subscribe(
          data => { console.log('PUT Request is successful', data); },
          error => { console.log('Error', error); }
        );
      this.SubmitdData();
    }else{
      alert("no")
    }
  


  }
}


