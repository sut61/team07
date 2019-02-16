import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from "@angular/router";
import { ActivatedRoute } from "@angular/router";
import { OrdersService } from '../Service/orders.service';
import { PartnersService } from '../Service/partners.service';
import { CatalogService } from '../Service/catalog.service';
import { InputdrugstroageService } from '../Service/inputdrugstroage.service';
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
  count: 0;
  names: any;

  drugrecive: any = { drugId: Number, name: String, price: String, qty: String };


  constructor(private drugService: DrugService,private route: ActivatedRoute, private httpClient: HttpClient, private ordersService: OrdersService, private prdersService: PartnersService, private catalogService: CatalogService,private inputdrugstroageService: InputdrugstroageService) { }
  displayedColumns: string[] = ['position', 'nameorders', 'namepartners', 'namecatalog','namedrug', 'amountin', 'amountcount', 'staff'];

  saveOrders() {
    let re = /(^O{1})(\d{7}$)/g
    let rs = /[d{0-9}$]/;
    this.count = 0;

    if (this.data.nameorders === undefined || this.data.nameorders === null) {

      this.count = 0;
    } else {
      this.count += 1;
    }
    if (this.partnersselect === undefined || this.partnersselect === null || this.partnersselect === "") {
      this.count = 0;
    } else {
      this.count += 1;
    }
    if (this.catalogselect === undefined || this.catalogselect === null || this.catalogselect === "") {
      this.count = 0;
    } else {
      this.count += 1;
    }
    if (this.data.amount === undefined || this.data.amount === null || this.data.amount === "") {
      this.count = 0;
    }
    else {
      if (rs.test(this.data.amount)) {
        this.count += 1;
      } else {
        this.count = 0;
        alert("ใส่เป็นตัวเลขเท่านั้น")
      }

    }

    if (this.count >= 4) {

      if (re.test(this.data.nameorders)) {

        this.drugService.getDrugById(Number(this.catalogselect)).subscribe(data => {
          this.drugrecive = data;
        });


        this.ordersService.PostOrders(String(this.data.nameorders), Number(this.partnersselect), Number(this.catalogselect),Number(this.catalogselect),String(this.names), String(this.data.amount)).subscribe(datas => {
          if (datas.status == "save") {

            this.drugrecive.qty = String(Number(this.drugrecive.qty) + Number(this.data.amount));
            this.inputdrugstroageService.updateDrug(Number(this.catalogselect), String(this.drugrecive.name), String(this.drugrecive.price), String(this.drugrecive.qty)).subscribe(data => {
              console.log(data);


            });
            alert("บันทึกสำเร็จ");
            window.location.reload();
          } else {
            alert(datas.status);
          }
        });

      } else {
        alert("ตัวแรกต้องเป็น O และตามด้วยหมายเลข  7 ตัวเท่านั้น ");
      }
    } else {
      alert("กรุณากรอกข้อมูลให้ครบถ้วน");
    }

  }

  ngOnInit() {

    this.route.params.subscribe(prams => {
      this.names = prams.name;
      console.log(prams);
    });
    this.ordersService.getOrders().subscribe(data => {
      this.orders = data;
      console.log(this.orders);
    });

    this.prdersService.getPartners().subscribe(data => {
      this.partners = data;
      console.log(this.partners);
    });

    this.catalogService.getCatalog().subscribe(data => {
      this.catalog = data;
      console.log(this.catalog);
    });
  }
}







