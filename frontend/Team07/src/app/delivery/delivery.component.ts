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
    console.log("all = ", this.detail)





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
    let rs = /[d{0-9}$]/;
    this.count = 0;
    this.detail.addressSelect = this.addressselect;

    if (this.detail.staff === undefined || this.detail.staff === "" || this.detail.staff == null) {

      this.count = 0;
    } else {

      this.count += 1;
    }
    if (this.detail.customer === undefined || this.detail.customer === "" || this.detail.customer == null) {

      this.count = 0;
    } else {

      this.count += 1;
    }
    if (this.detail.drug === undefined || this.detail.drug === "" || this.detail.drug == null) {

      this.count = 0;
    } else {
      this.count += 1;
    }

    if (this.detail.addressSelect === undefined || this.detail.addressSelect === "" || this.detail.addressSelect == null) {

      this.count = 0;
    } else {
      this.count += 1;
    }

    if (this.detail.amount === undefined || this.detail.amount === "" || this.detail.amount == null) {

      this.count = 0;
    } else {

      if (rs.test(this.detail.amount)) {
        // this.count += 1;
        if (String(this.detail.amount).length >= 8) {
          alert("จำนวนยาเกินกว่าที่มีใน Database ")
        } else {
          this.count += 1;
        }
      } else {
        this.count = 0;
        alert("ใส่ยอดสุทธิเป็นตัวเลขเท่านั้น")
      }
    }
    if (this.detail.netamount === undefined || this.detail.netamount === "" || this.detail.netamount == null) {
      this.count = 0;
    } else {
      if (rs.test(this.detail.netamount)) {
        this.count += 1;
      } else {
        this.count = 0;
        alert("ใส่เป็นตัวเลขเท่านั้น")
      }
      //this.count += 1;
    }



    if (this.count >= 6) {
      this.detail.addressSelect = this.addressselect;
      this.httpClient.post('http://localhost:8080/Invoice-insert/StaffId/' + this.detail.staff + '/customerId/' + this.detail.customer + '/addressId/' + this.detail.addressSelect + '/drugId/' + this.detail.drug + '/Amount/' + String(parseInt(this.detail.amount)) + '/Netamount/' + String(this.detail.netamount), this.emp)
        .subscribe(
          datas => { console.log('PUT Request is successful', datas); },
          error => { console.log('Error', error); }
        );

      this.SubmitdData();

    } else {
      this.count = 0;
      alert("กรุณากรอกข้อมูลให้ครบถ้วน")
    }
  }
}


