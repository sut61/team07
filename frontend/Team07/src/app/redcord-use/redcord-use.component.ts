import { Component, OnInit } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Router } from "@angular/router";
import { ActivatedRoute } from "@angular/router";

// import service
import { RegisterService } from "../Service/register.service"; // get initial gender bloodtype all
import { CategoryService } from "../Service/category.service"; // get category all
import { RedcorduseService } from "../Service/redcorduse.service"; // get Customer by Id
import { Observable } from "rxjs";

@Component({
  selector: "app-redcord-use",
  templateUrl: "./redcord-use.component.html",
  styleUrls: ["./redcord-use.component.css"]
})
export class RedcordUseComponent implements OnInit {
  // get data from db
  drugdata: Array<any>;
  drugdataselect = "";
  Iinitials: Array<any>;
  Initialselect = "";
  genders: Array<any>;
  genderselect = "";
  bloodtypes: Array<any>;
  bloodtypeselect = "";

  customer = {
    customerId: Number,
    customerName: String,
    customerPhonenumber: String,
    customerAddress: String,
    customerUserID: String,
    customerPassword: String,
    initial: { initialId: Number, name: String },
    gender: { genderId: Number, sex: String },
    bloodType: { bloodTypeId: Number, name: Number }
  }; // customer by name
  //customerselect = '';

  public API = "//localhost:8080";

  data: any = {};

  constructor(
    private http: HttpClient,
    private route: ActivatedRoute,
    private redcorduseservice: RedcorduseService,
    private registerservice: RegisterService,
    private router: Router,
    private categoryservice: CategoryService,
    private httpClient: HttpClient
  ) {}

  getDrugdataAll(): Observable<any> {
    return this.http.get(this.API + "/Drugdata-list/");
  }

  SaveRedcord() {
    // console.log(this.data.symptom)
    // console.log(this.categoryselect)

    this.redcorduseservice
      .postRedcorduse(
        String(this.data.symptom),
        Number(this.drugdataselect),
        Number(1),
        Number(this.customer.customerId)
      )
      .subscribe(data => {
        console.log(data);
      });
  }
  searchCustomername() {
    console.log(this.data.namecus);
    if (this.data.namecus === undefined || this.data.namecus == "") {
      alert("กรุณาใส่ชื่อ");
    } else {
      this.redcorduseservice
        .getCustomerByname(String(this.data.namecus))
        .subscribe(data => {
          this.customer = data;
        });
    }
  }
  ngOnInit() {
    this.getDrugdataAll().subscribe(datas => {
      this.drugdata = datas;
      console.log(datas)
    });
    this.redcorduseservice
      .getCustomerByname(String("John"))
      .subscribe(data => {
        this.customer = data;
        console.log(this.customer);
      });


  }
}
