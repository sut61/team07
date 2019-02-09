import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CategoryService } from '../Service/category.service';
import { Router } from "@angular/router";
import { InputdrugstroageService } from '../Service/inputdrugstroage.service';
import { ActivatedRoute } from "@angular/router";
import { DrugService } from '../Service/drug.service';
import { PrescriptionService } from '../Service/prescription.service';

@Component({
  selector: 'app-drug-storage-menu',
  templateUrl: './drug-storage-menu.component.html',
  styleUrls: ['./drug-storage-menu.component.css']
})
export class DrugStorageMenuComponent implements OnInit {

  category: Array<any>;
  prescription: Array<any>;
  drug: Array<any>;
  drugselect = '';
  categoryselect = '';
  preId: any;
  data: any = {}
  datas: any = {}
  count: 0;
  names: any;

  constructor(private drugService: DrugService, private route: ActivatedRoute, private router: Router, private categoryService: CategoryService, private httpClient: HttpClient, private inputdrugstroageService: InputdrugstroageService, private pre: PrescriptionService) { }
  displayedColumns: string[] = ['position', 'name', 'drugname', 'category', 'staff'];

  showdata() {

    console.log("namepre" + " = " + this.data.namepre)
    console.log("drugId" + " = " + this.drugselect)
    console.log("categoryId" + " = " + this.categoryselect)

    console.log("staffId" + " = " + this.preId)

  }

  sumbitData() {

    let re = /(^P{1})(\d{8,13}$)/g
    this.count = 0;

    if (this.data.namepre === undefined || this.data.namepre === null) {
      this.count = 0;
    } else {
      this.count += 1;
    }
    if (this.drugselect === undefined || this.drugselect === null || this.drugselect === "") {
      this.count = 0;
    } else {
      this.count += 1;
    }
    if (this.categoryselect === undefined || this.categoryselect === null || this.categoryselect === "") {
      this.count = 0;
    } else {
      this.count += 1;
    }
    if (this.count >= 3) {
      if (re.test(this.data.namepre)) {
        this.inputdrugstroageService.summbituyPrescription(String(this.data.namepre), Number(this.categoryselect), Number(this.drugselect), String(this.names)).subscribe(dss => {
          if (dss.status == "save") {
            this.pre.getPrescription().subscribe(data => {
              this.prescription = data;
              this.preId = this.prescription.length;
              console.log(this.prescription);

            })
            alert("บันทึกสำเร็จ")
          } else if (dss.status == "save-false") {
            alert(dss.statuss)
          }
        })
      } else {
        alert("ตัวแรกต้องเป็น P และตามด้วยหมายเลข  8-12 ตัว ");
      }


    } else {
      alert("กรุณากรอกข้อมูลให้ครบถ้วน")
    }





  }




  ngOnInit() {
    this.route.params.subscribe(prams => {
      this.names = prams.name;
      console.log(prams)
    })
    this.categoryService.getCategory().subscribe(data => {
      this.category = data;
      console.log(this.category)
    })

    this.pre.getPrescription().subscribe(data => {
      this.prescription = data;
      this.preId = this.prescription.length;
      console.log(this.prescription);

    })
    this.drugService.getDrug().subscribe(data => {
      this.drug = data;
      console.log(this.drug)
    })



  }

}
