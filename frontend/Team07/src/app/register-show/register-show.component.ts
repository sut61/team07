import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { RegisterService } from '../Service/register.service';
import { HttpClient } from '@angular/common/http';
import { Router } from "@angular/router";

import { CategoryService } from '../Service/category.service';
@Component({
  selector: 'app-register-show',
  templateUrl: './register-show.component.html',
  styleUrls: ['./register-show.component.css']
})
export class RegisterShowComponent implements OnInit {

  data: any = {}
  category: Array<any>;
  constructor(private route: ActivatedRoute, private app: RegisterService,private categoryService: CategoryService,private router: Router,private httpClient: HttpClient) { }
  initialId: any;
  genderId: any;
  bloodtypeId: any;
  saveregister() {
    this.app.Customersumbit(Number(this.initialId),String(this.data.firstname),Number(this.genderId),Number(this.bloodtypeId),String(this.data.address),String(this.data.phonenumber),String(this.data.username),String(this.data.password)).subscribe(data => {
      console.log(this.data)
    })
  }

  ngOnInit() {

    this.route.params.subscribe(prams => {
      this.data = prams

      if (prams.initial == "Mr.") {
        this.initialId = 1;
      } else if (prams.initial == "Mrs.") {
        this.initialId = 2;
      }
      else if (prams.initial == "Miss.") {
        this.initialId = 3;
      }
      if (prams.gender == "None") {
        this.genderId = 1;
      } else if (prams.gender == "Male") {
        this.genderId = 2;
      }
      else if (prams.gender == "Female") {
        this.genderId = 3;
      }
      else if (prams.gender == "Tom") {
        this.genderId = 4;
      }
      else if (prams.gender == "Gay") {
        this.genderId = 5;
      }
      if (prams.bloodType == "A") {
        this.bloodtypeId = 1;
      } else if (prams.bloodType == "B") {
        this.bloodtypeId = 2;
      }
      else if (prams.bloodType == "O") {
        this.bloodtypeId = 3;
      }
      else if (prams.bloodType == "AB") {
        this.bloodtypeId = 4;
      }



      console.log(prams)
      console.log("initial = " + this.initialId)
      console.log("gender = " + this.genderId)
      console.log("bloodtype = " + this.bloodtypeId)

    })

    this.categoryService.getCategory().subscribe(data => {
      this.category = data;
      console.log(this.category)
    })



  }

}