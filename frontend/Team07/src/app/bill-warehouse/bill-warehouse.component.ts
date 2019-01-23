import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink } from "@angular/router";
import { Router } from '@angular/router';
import { BillOfladingService } from '../Service/bill-oflading.service';



@Component({
  selector: 'app-bill-warehouse',
  templateUrl: './bill-warehouse.component.html',
  styleUrls: ['./bill-warehouse.component.css']
})
export class BillWarehouseComponent implements OnInit {
  data: any = {}

  bill_of_lading = {
    billId: '', product: { productId: '', name: '', price: '', qty: '' },
    typeproduct: { typeId: '', nametype: '' }, user: { userId: '', username: '', password: '' }, date: ''
  };

  constructor(private route: ActivatedRoute, private router: Router, private app: BillOfladingService) {
  }
  ngOnInit() {

  


  }
  pushBillId() {
    if (this.data.id == undefined || this.data.id == null) {
      alert('Out of range')
    } else if (this.data.id != undefined && this.data.id != null) {
      this.app.getdata(this.bill_of_lading, this.data.id, () => {
        this.bill_of_lading = this.app.bill_of_lading
        console.log(this.bill_of_lading);
        if (this.bill_of_lading == null) {
          alert('Out of range')
        }
      })
    }
    //console.log(this.data)

  }

  selectLink() {

    this.router.navigate(['select']);

  }


}
