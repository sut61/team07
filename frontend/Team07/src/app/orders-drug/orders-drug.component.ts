import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from "@angular/router";
import { ActivatedRoute } from "@angular/router";
import { OrdersService } from '../Service/orders.service';
import { PartnersService } from '../Service/partners.service';
import { CatalogService } from '../Service/catalog.service';
import { DrugService } from '../Service/drug.service';

@Component({
  selector: 'app-orders-drug',
  templateUrl: './orders-drug.component.html',
  styleUrls: ['./orders-drug.component.css']
})
export class OrdersDrugComponent implements OnInit {
  orders: Array<any>;
  ordersselect = '';
  partners: Array<any>;
  partnersselect = '';
  catalog: Array<any>;
  catalogselect = '';
  drug: Array<any>;
  drugselect = '';
  data: any = {}
  datas: any = {}


  constructor(private httpClient: HttpClient, private ordersService: OrdersService, private prdersService: PartnersService, private catalogService: CatalogService) { }

  // showdata() {
  //   console.log("data.nameorders = " + this.data.nameorders)
  //   console.log("partnersselect = " + this.partnersselect)

  //   console.log("catalogselect = " + this.catalogselect)
  //   console.log("data.amount = " + this.data.amount)

  // }

  saveOrders() {
    if (this.data.nameorders === undefined || this.data.nameorders === null) {
      alert("ใส่ชื่อใบสั่ง")
    }
    if (this.partnersselect === undefined || this.partnersselect === null || this.partnersselect === "") {
      alert("เลือกผู้ขาย")
    }
    if (this.catalogselect === undefined || this.catalogselect === null || this.catalogselect === "") {
      alert("เลือกรายการยา")
    }

    if (this.data.amount === undefined || this.data.amount === null || this.data.amount === "") {
      alert("ใส่จำนวน")
    }
    else  {
      this.ordersService.PostOrders(String(this.data.nameorders), Number(this.partnersselect), Number(this.catalogselect), String(this.data.amount)).subscribe(datas => {
        console.log(datas)
      })
    }
  }

  ngOnInit() {
    this.ordersService.getOrders().subscribe(data => {
      this.orders = data;
      console.log(this.orders)
    })

    this.prdersService.getPartners().subscribe(data => {
      this.partners = data;
      console.log(this.partners)
    })

    this.catalogService.getCatalog().subscribe(data => {
      this.catalog = data;
      console.log(this.catalog)
    })
  }
}







