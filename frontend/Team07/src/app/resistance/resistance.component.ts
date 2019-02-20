import { Component, OnInit } from "@angular/core";
import { RedcorduseService } from "../Service/redcorduse.service";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Router } from "@angular/router";

import { DeliveryService } from "../Service/delivery.service";
import { ResistanceService } from "../Service/resistance.service";

import { SelectionModel } from "@angular/cdk/collections";
import { MatTableDataSource } from "@angular/material";
import { map, filter } from "rxjs/operators";
import { Observable } from "rxjs";
import { AppserviceService } from '../Service/appservice.service';

@Component({
  selector: "app-resistance",
  templateUrl: "./resistance.component.html",
  styleUrls: ["./resistance.component.css"]
})
export class ResistanceComponent implements OnInit {

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

  displayedColumns: string[] = [
    "position",
    "customername",
    "drug",
    "symptom"
  ];
  displayedColumns2: string[] = [
    "position",
    "customername",
    "drug",
    "symptom", "result"
  ];

  data: any = {};
  customers: Array<any>;
  customerselect = "";

  favoriteSeason: string;
  redcorddruguse: Array<any>;
  redcorddruguseselect = "";
  count: 0;
  res: Array<any>;

  constructor(
    private http: HttpClient,
    private app: AppserviceService,
    private redcorduseService: RedcorduseService,
    private resistanceservice: ResistanceService,
    private deliveryService: DeliveryService
  ) { }




  ResistancePost(RecordDrugUseId: Number, result: String): Observable<any> {
    return this.http.post(
      this.API +
      "/Resistance-Insert/RecordDrugUseId/" +
      RecordDrugUseId +
      "/result/" +
      result,
      {}
    );
  }

  getResistanceAll(): Observable<any> {
    return this.http.get(this.API + "/Resistance-list/");
  }

  SaveResistance() {
    let re = /(Normal|Resist)/g;

    this.count = 0;
    if (
      this.data.status === undefined ||
      this.data.status === null ||
      this.data.status === ""
    ) {
      this.count = 0;
      alert("กรุณากรอกข้อมูลให้ครบถ้วน");
    } else {
      if (re.test(this.data.status) && String(this.data.status).length <= 6) {
        this.count += 1;
      } else {
        alert("กรุณากรอก 'Normal' หรือ 'Resist' ใน 'ผลการดื้อยา'");
        this.count = 0;
      }
    }
    if (
      this.customerselect === undefined ||
      this.customerselect === null ||
      this.customerselect === ""
    ) {
      this.count = 0;
    } else {
      this.count += 1;
    }

    if (this.count >= 2) {
      this.ResistancePost(
        Number(this.customerselect),
        String(this.data.status)
      ).subscribe(data => {
        if (data.status == "save") {
          alert("บันทึกสำเร็จ");
          this.getResistanceAll().subscribe(datasc => {
            this.res = datasc;
            console.log(datasc);
          });
        } else {
          alert("บันทึกไม่สำเร็จ")

        }
        //console.log(data);
      });
    } else {

    }
  }

  ngOnInit() {

    this.getStaffOnline().subscribe(data => {
      console.log(data);
      this.staffdb = data;
      this.names = this.staffdb.staffUser;
      console.log(this.names)
    })
    this.redcorduseService.getRedcorduseAll().subscribe(datas => {
      this.redcorddruguse = datas;
      console.log(datas);
    });


    this.deliveryService.getCustomers().subscribe(data => {
      this.customers = data;
      console.log(this.customers);
    });

    this.getResistanceAll().subscribe(datasc => {
      this.res = datasc;
      console.log(datasc);
    });

  }

}
