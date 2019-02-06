import { Component, OnInit } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { NgModule } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
data:any ={}
  constructor(private route:ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(prams=>{
      this.data = prams
      console.log(prams)
    })
  }

}
