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

  constructor(private drugService: DrugService, private route: ActivatedRoute, private router: Router, private categoryService: CategoryService, private httpClient: HttpClient, private inputdrugstroageService: InputdrugstroageService, private pre: PrescriptionService) { }
  displayedColumns: string[] = ['position', 'name', 'drugname', 'category','staff'];
  
  showdata() {

    console.log("namepre" + " = " + this.data.namepre)
    console.log("drugId" + " = " + this.drugselect)
    console.log("categoryId" + " = " + this.categoryselect)

    console.log("staffId" + " = " + this.preId)

  }

  sumbitData() {

    this.inputdrugstroageService.summbituyPrescription(String(this.data.namepre), Number(this.categoryselect), Number(this.categoryselect), Number(1)).subscribe(data => {
      console.log(this.data)
    })

  }




  ngOnInit() {
    this.route.params.subscribe(prams => {
      this.datas = prams
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
      if(this.preId == "undefined"){
        this.preId == 1;
      }

    })
    this.drugService.getDrug().subscribe(data => {
      this.drug = data;
      console.log(this.drug)
    })



  }

}
