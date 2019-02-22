import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { RegisterService } from '../Service/register.service';
import { HttpClient } from '@angular/common/http';
import { AppserviceService } from "../Service/appservice.service";
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {
  initials: Array<any>;
  initialselect = '';
  genders: Array<any>;
  genderselect = '';
  bloodTypes: Array<any>;
  bloodTypeselect = '';
  staffdb: any = { staffId: Number, staffName: String, staffUser: String, staffPass: String, staffPhone: String, online: String }
  count: 0;

  data: any = {
    initial: '',
    firstname: '',
    gender: '',
    bloodTypeSelect: '',
    allergyHistory: '',
    address: '',
    phonenumber: ''


  };
  customers: any = {
    initialSelect: '',
    genderSelect: '',
    bloodTypeSelect: ''
  };


  showdatainput() {
    console.log("initialId = " + this.initialselect)
    console.log("genderselect = " + this.genderselect)
    console.log("bloodTypeselect = " + this.bloodTypeselect)


  }
  constructor(private app: AppserviceService, private router: Router, private registerService: RegisterService, private http: HttpClient) { }
  public API = "//localhost:8080";
  names: any;

  getStaffOnline() {
    return this.http.get(this.API + '/StaffOnline/' + "true");
  }

  setstaffOfline() {
    this.app.setStaffOfline(Number(this.staffdb.staffId)).subscribe(data => {
      console.log(data);
    })
  }

  ngOnInit() {


    this.getStaffOnline().subscribe(data => {
      console.log(data);
      this.staffdb = data;
      this.names = this.staffdb.staffUser;
      console.log(this.names)
    })


    this.registerService.getInitials().subscribe(data => {
      this.initials = data;
      console.log(this.initials);
    });

    this.registerService.getGenders().subscribe(data => {
      this.genders = data;
      console.log(this.genders);
    });

    this.registerService.getBloodTypes().subscribe(data => {
      this.bloodTypes = data;
      console.log(this.bloodTypes);
    });
  }

  SubmitdData() {//Data
    console.log(this.data)
    const data = this.data

    this.router.navigate(['register-show', {

      initial: data.initial,
      firstname: data.firstname,
      gender: data.gender,
      bloodType: data.bloodType,
      allergyHistory: data.allergyHistory,
      address: data.address,
      phonenumber: data.phonenumber,





    }])

  }

  save() {
    let red = /[A-Za-z]{3,20}/g
    let rs = /[0]{1}[0-9]{9}/g;
    this.count = 0;
    if (this.data.initial === undefined || this.data.initial === "" || this.data.initial == "") {

      this.count = 0;
    } else {

      this.count += 1;
    }
    if (this.data.firstname === undefined || this.data.firstname === "" || this.data.firstname == "") {

      this.count = 0;
    } else {

      if (red.test(this.data.firstname)) {
        this.count += 1;
      }
      else {
        this.count = 0;
        alert("กรุณากรอกข้อมูลเป็นตัวอักษรภาษาอังกฤษเท่านั้น และต้องมากกว่า 3 ตัว")
        return;
      }
    }
    if (this.data.gender === undefined || this.data.gender === "" || this.data.gender == null) {

      this.count = 0;
    } else {
      this.count += 1;
    }

    if (this.data.bloodType === undefined || this.data.bloodType === "" || this.data.bloodType == null) {

      this.count = 0;
    } else {
      this.count += 1;
    }

    if (this.data.allergyHistory === undefined || this.data.allergyHistory === "" || this.data.allergyHistory == null) {
      alert("กรุณากรอกข้อมูลประวัติการแพ้ยา")
      this.count = 0;
    } else {
      this.count += 1;
    }

    if (this.data.address === undefined || this.data.address === "" || this.data.address == null) {

      this.count = 0;
    } else {
      if (this.data.address.length < 3) {

        this.count = 0;
        alert("ข้อมูลสั้นไปกรุณากรอกใหม่")
        return;
      } else if (this.data.address.length > 40) {

        this.count = 0;
        alert("ข้อมูลยาวเกินไปกรุณากรอกใหม่")
        return;
      } else {
        this.count += 1;
      }
    }

    if (this.data.phonenumber === undefined || this.data.phonenumber === "" || this.data.phonenumber == null) {

      this.count = 0;
    }
    else {
      if (rs.test(this.data.phonenumber)) {
        this.count += 1;
      } else {
        this.count = 0;
        alert("กรอกเป็นตัวเลขและขึ้นต้นด้วยเลข 0 เท่านั้น และกรอกให้ครบ 10 ตัว")
        return;
      }
    }
    console.log("cont" + this.count);

    if (this.count >= 7) {
      this.SubmitdData();
    } else {
      alert("กรอกไม่ครบ")
    }


  }







}