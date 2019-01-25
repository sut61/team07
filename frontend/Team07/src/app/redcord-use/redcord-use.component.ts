import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CategoryService } from '../Service/category.service';
import { Router } from "@angular/router";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-redcord-use',
  templateUrl: './redcord-use.component.html',
  styleUrls: ['./redcord-use.component.css']
})
export class RedcordUseComponent implements OnInit {
  category : Array<any>;
  categoryselect ='';

  data :any ={}
  datas :any ={}

  constructor(private route:ActivatedRoute,private router:Router,private categoryService: CategoryService, private httpClient: HttpClient) { }


  ngOnInit() {
    this.route.params.subscribe(prams=>{
      this.datas = prams
      console.log(prams)
    })
    this.categoryService.getCategory().subscribe(data=>{
      this.category = data;
      console.log(this.category)
    })
  }

}
