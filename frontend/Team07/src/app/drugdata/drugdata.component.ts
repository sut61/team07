import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CategoryService } from '../Service/category.service';
import { MedicineService } from '../Service/medicine.service';
import { Router } from "@angular/router";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-drugdata',
  templateUrl: './drugdata.component.html',
  styleUrls: ['./drugdata.component.css']
})
export class DrugdataComponent implements OnInit {
  category : Array<any>;
  categoryselect ='';
  medicine : Array<any>;
  medicines = '';
  data :any ={}  
  datas :any ={}
  constructor(private route:ActivatedRoute,private router:Router,private medicineService: MedicineService,private categoryService: CategoryService, private httpClient: HttpClient) { }
  
 
  showdata(){
    console.log(this.data.namedrug)
    console.log(this.categoryselect)
    console.log(this.medicines)
    console.log(this.data.nameexplantion)
    
  }

  ngOnInit() {
    this.categoryService.getCategory().subscribe(data=>{
      this.category = data;
      console.log(this.category)
    })
    this.medicineService.getMedicine().subscribe(data=>{
      this.medicine = data;
      console.log(this.medicine)
    })
  }
}
