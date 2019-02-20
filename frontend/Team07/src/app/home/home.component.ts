import { Component, OnInit } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { NgModule } from '@angular/core';
import { ActivatedRoute } from "@angular/router";


import { HttpClient } from '@angular/common/http';
import { AppserviceService } from "../Service/appservice.service";
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  data: any = {}
  names: any;
  public API = '//localhost:8080';
  staffdb: any = { staffId: Number, staffName: String, staffUser: String, staffPass: String, staffPhone: String, online: String }


  constructor(private route: ActivatedRoute, private app: AppserviceService, private http: HttpClient) { }

  setstaffOfline() {
    this.app.setStaffOfline(Number(this.staffdb.staffId)).subscribe(data => {
      console.log(data);
    })
  }


  getStaffOnline() {
    return this.http.get(this.API + '/StaffOnline/' + "true");
  }



  ngOnInit() {


    this.route.params.subscribe(prams => {
      this.staffdb = prams;
      console.log(prams)
      if (prams === null || prams === undefined) {
        ////// 
      } else {
        if (prams.staffId === NaN) {
          ////
        } else {
          this.app.setStaffOnline(Number(prams.staffId), String(prams.staffName), String(prams.staffUser), String(prams.staffPass), String(prams.staffPhone)).subscribe(data => {
            console.log(prams);
          });
        }
      }


    });

    if (this.staffdb.staffUser === null || this.staffdb.staffUser === undefined) {

    } else {
      this.getStaffOnline().subscribe(data => {
        console.log(data);
        this.staffdb = data;
        this.names = this.staffdb.staffUser;
        console.log(this.names);
      });

    }





  }

}
