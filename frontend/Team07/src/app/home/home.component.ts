import { Component, OnInit } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { NgModule } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import { AppserviceService } from "../Service/appservice.service";
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
data:any ={}
  constructor(private route:ActivatedRoute,private app :AppserviceService) { }

  ngOnInit() {
    this.route.params.subscribe(prams => {
      console.log(prams.staffId);
      this.data = prams;
      this.app.setStaffOnline(Number(1)).subscribe(data => {
        console.log(data);
      });

    });






  }

}
