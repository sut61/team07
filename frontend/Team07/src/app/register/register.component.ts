import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { RegisterService } from '../Service/register.service';
import { HttpClient } from '@angular/common/http';

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

  data: any = {
    initial: '',
    firstname: '',
    gender: '',
    bloodTypeSelect: '',
    address: '',
    phonenumber: '',
    username: '',
    password: ''
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
  constructor(private router: Router, private registerService: RegisterService, private httpClient: HttpClient) { }

  ngOnInit() {
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
      address: data.address,
      phonenumber: data.phonenumber,
      username: data.username,
      password: data.password,
      
      
      
    }])

  }



}







