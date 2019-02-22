import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CategoryService } from '../Service/category.service';
import { MedicineService } from '../Service/medicine.service';
import { Router } from "@angular/router";
import { ActivatedRoute } from "@angular/router";
import { DrugService } from '../Service/drug.service';
import { AppserviceService } from "../Service/appservice.service";
import { DrugdataService } from '../Service/drugdata.service';


@Component({
  selector: 'app-drugdata',
  templateUrl: './drugdata.component.html',
  styleUrls: ['./drugdata.component.css']
})
export class DrugdataComponent implements OnInit {
  category: Array<any>;
  categoryselect = '';
  medicine: Array<any>;
  medicineselect = '';
  data: any = {}
  datas: any = {}
  staffId: any = {}
  count: 0;

  drug: Array<any>;
  drugselect = '';

  names: any;
  public API = '//localhost:8080';
  staffdb: any = { staffId: Number, staffName: String, staffUser: String, staffPass: String, staffPhone: String, online: String }

  constructor(private http: HttpClient, private app: AppserviceService, private route: ActivatedRoute, private drugdataService: DrugdataService, private drugService: DrugService, private router: Router, private medicineService: MedicineService, private categoryService: CategoryService, private httpClient: HttpClient) { }


  setstaffOfline() {
    this.app.setStaffOfline(Number(this.staffdb.staffId)).subscribe(data => {
      console.log(data);
    })
  }


  getStaffOnline() {
    return this.http.get(this.API + '/StaffOnline/' + "true");
  }

  Savedrugdata() {
    let mc = /\w{2,35}$/g;

    this.count = 0;
    if (this.drugselect === undefined || this.drugselect === null || this.drugselect === "") {
      this.count = 0;
    }else {
      this.count += 1;
    }
    if (this.categoryselect === undefined || this.categoryselect === null || this.categoryselect === "") {
      this.count = 0;
    }else {
      this.count += 1;
    }
    if (this.medicineselect === undefined || this.medicineselect === null || this.medicineselect === "") {
      this.count = 0;
    }else {
      this.count += 1;
    }
    if (this.data.nameexplantion === undefined || this.data.nameexplantion === null) {
      this.count = 0;
    } else {
      this.count += 1;
    }
    if (this.count >= 4) {
      if (mc.test(this.data.Drugdata)) {
        this.drugdataService.DrugDataPost(String(this.data.nameexplantion), Number(this.drugselect), Number(this.staffdb.staffId), Number(this.categoryselect), Number(this.medicineselect)).subscribe(data => {
      console.log(this.data)
      if (data.status == "save") {
        alert("บันทึกสำเร็จ")
      } else {
        alert(data.status)
      }
    })
      } else{
          alert("กรอกให้ครบถ้วน")
        }
    }else {
        alert("กรุณากรอกข้อมูลให้ครบถ้วน")
    }
}
  Savemedicine() {
    this.drugdataService.MedicinePost(String(this.data.medicinex)).subscribe(data => {
      console.log(this.data)
    })

  }

  showdata() {
    console.log(this.data.medicinex)

    // console.log(this.data.nameexplantion)
    // console.log(this.drugselect)
    // console.log(this.categoryselect)
    // console.log(this.staffId)
    // console.log(this.medicineselect)

  }

  ngOnInit() {

    this.getStaffOnline().subscribe(data => {
      console.log(data);
      this.staffdb = data;
      this.names = this.staffdb.staffUser;
      console.log(this.names)
    })
    this.categoryService.getCategory().subscribe(data => {
      this.category = data;
      this.staffId = data.length;
      console.log(this.category)
    })
    this.medicineService.getMedicine().subscribe(data => {
      this.medicine = data;
      console.log(this.medicine)
    })

    this.drugService.getDrug().subscribe(data => {
      this.drug = data;
      console.log(this.drug)
    })
  }
}
