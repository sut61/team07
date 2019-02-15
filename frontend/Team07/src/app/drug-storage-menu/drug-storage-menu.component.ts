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
  ggss: any = { drugId: Number, name: String, price: String, qty: String };

  constructor(private drugService: DrugService, private route: ActivatedRoute, private router: Router, private categoryService: CategoryService, private httpClient: HttpClient, private inputdrugstroageService: InputdrugstroageService, private pre: PrescriptionService) { }
  displayedColumns: string[] = ['position', 'name', 'drugname', 'category', 'amountout', 'amountcount', 'staff'];

  showdata() {

    console.log("namepre" + " = " + this.data.namepre)
    console.log("drugId" + " = " + this.drugselect)
    console.log("categoryId" + " = " + this.categoryselect)

    console.log("staffId" + " = " + this.preId)

  }

  sumbitData() {
  


    let re = /(^P{1})(\d{7}$)/g
    let rs = /[0-9999]{1,4}/;
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
    if (this.data.amounts === undefined || this.data.amounts === null || this.data.amounts === "") {
      this.count = 0;
    }
    else {
      if (rs.test(this.data.amounts)) {
        this.count += 1;
      } else {
        this.count = 0;
        alert("ใส่เป็นตัวเลขเท่านั้น")
      }

    }

    if (this.count >= 4) {
      if (re.test(this.data.namepre)) {
        this.drugService.getDrugById(Number(this.drugselect)).subscribe(data => {
          this.ggss = data;
        });

        this.inputdrugstroageService.summbituyPrescription(String(this.data.namepre), String(this.data.amounts), Number(this.categoryselect), Number(this.drugselect), String(this.names)).subscribe(dss => {
          if (dss.status == "save") {


            this.ggss.qty = String(Number(this.ggss.qty) - Number(this.data.amounts));
            this.inputdrugstroageService.updateDrug(Number(this.drugselect), String(this.ggss.name), String(this.ggss.price), String(this.ggss.qty)).subscribe(data => {
              console.log(data);
              
      
            });

            this.pre.getPrescription().subscribe(datassg => {
              this.prescription = datassg;
          
              this.preId = this.prescription.length;
              console.log(this.prescription);
            });

            alert("บันทึกสำเร็จ")
            window.location.reload();
           // this.router.navigate(['drug-stroagemenu', {name:this.names}]);
           

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


    })
    this.drugService.getDrug().subscribe(data => {
      this.drug = data;
      console.log(this.drug)
    })






  }

}
