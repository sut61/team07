import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CategoryService } from '../Service/category.service';
import { MedicineService } from '../Service/medicine.service';
import { Router } from "@angular/router";
import {ActivatedRoute} from "@angular/router";
import { DrugService } from '../Service/drug.service';

import { DrugdataService } from '../Service/drugdata.service';


@Component({
  selector: 'app-drugdata',
  templateUrl: './drugdata.component.html',
  styleUrls: ['./drugdata.component.css']
})
export class DrugdataComponent implements OnInit {
  category : Array<any>;
  categoryselect ='';
  medicine : Array<any>;
  medicineselect = '';
  data :any ={}  
  datas :any ={}
  staffId  : any = {}

  drug: Array<any>;
  drugselect = '';
  constructor(private route:ActivatedRoute,private drugdataService : DrugdataService,private drugService :DrugService ,private router:Router,private medicineService: MedicineService,private categoryService: CategoryService, private httpClient: HttpClient) { }
  

  Savedrugdata(){
    this.drugdataService.DrugDataPost(String(this.data.nameexplantion),Number(this.drugselect),Number(1),Number(this.categoryselect),Number(this.medicineselect)).subscribe(data =>{
      console.log(this.data)
    })
  }
  Savemedicine(){
    this.drugdataService.MedicinePost(String(this.data.medicinex)).subscribe(data=>{
      console.log(this.data)
    })

  }
 
  showdata(){
    console.log(this.data.medicinex)

    // console.log(this.data.nameexplantion)
    // console.log(this.drugselect)
    // console.log(this.categoryselect)
    // console.log(this.staffId)
    // console.log(this.medicineselect)
    
  }

  ngOnInit() {
    this.categoryService.getCategory().subscribe(data=>{
      this.category = data;
      this.staffId = data.length;
      console.log(this.category)
    })
    this.medicineService.getMedicine().subscribe(data=>{
      this.medicine = data;
      console.log(this.medicine)
    })

    this.drugService.getDrug().subscribe(data => {
      this.drug = data;
      console.log(this.drug)
    })
  }
}
