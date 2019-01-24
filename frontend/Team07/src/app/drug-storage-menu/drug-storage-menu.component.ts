import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CategoryService } from '../Service/category.service';
import { Router } from "@angular/router";
@Component({
  selector: 'app-drug-storage-menu',
  templateUrl: './drug-storage-menu.component.html',
  styleUrls: ['./drug-storage-menu.component.css']
})
export class DrugStorageMenuComponent implements OnInit {

  category : Array<any>;
  categoryselect ='';

  data :any ={}
  constructor(private router:Router,private categoryService: CategoryService, private httpClient: HttpClient) { }

  showdata(){
    console.log(this.data)
    console.log(this.categoryselect)
    
  }

  ngOnInit() {
    this.categoryService.getCategory().subscribe(data=>{
      this.category = data;
      console.log(this.category)
    })
  }

}
