import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CategoryService } from '../Service/category.service';
import { Router } from "@angular/router";
import { InputdrugstroageService } from '../Service/inputdrugstroage.service';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-drug-storage-menu',
  templateUrl: './drug-storage-menu.component.html',
  styleUrls: ['./drug-storage-menu.component.css']
})
export class DrugStorageMenuComponent implements OnInit {

  category : Array<any>;
  categoryselect ='';

  data :any ={}
  constructor(private route:ActivatedRoute,private router:Router,private categoryService: CategoryService, private httpClient: HttpClient,private inputdrugstroageService : InputdrugstroageService) { }

  showdata(){
    console.log(this.data.namedrug)
    console.log(this.categoryselect)
  }

  sumbitData(){
  this.inputdrugstroageService.sumbittycategory(Number(1),String(this.data.namedrug)).subscribe(data=>{
    console.log(this.data)

    this.inputdrugstroageService.sumbittyDrug(Number(1),String(this.categoryselect)).subscribe(data=>{
      console.log(this.data)
    })

    this.inputdrugstroageService.summbituyPrescription(Number(1),String(this.categoryselect)).subscribe(data=>{
      console.log(this.data)
    })

  })
  
  }

 

  ngOnInit() {
    this.route.params.subscribe(prams=>{
      this.data = prams
      console.log(prams)
    })
    this.categoryService.getCategory().subscribe(data=>{
      this.category = data;
      console.log(this.category)
    })
  }

}
