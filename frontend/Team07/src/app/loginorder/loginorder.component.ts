import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { AppserviceService } from '../Service/appservice.service';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-loginorder',
  templateUrl: './loginorder.component.html',
  styleUrls: ['./loginorder.component.css']
})
export class LoginorderComponent implements OnInit {

  credentials = { username: '', password: '' };
  constructor(private app: AppserviceService, private router: Router, private http: HttpClient) { }

  loginorder() {
    console.log(this.credentials)
    if (this.credentials.username === '' || this.credentials.password === '') {
      alert('please Enter usernaem or pass')
    } else {
      this.app.authenticate2(this.credentials, () => {
        if (this.app.authenticated2) {
          this.router.navigate(['orders-drug', { name: this.credentials.username, pass: this.credentials.password }]);
        } else {
          //  alert('not user')
          alert('No User ')
        }
      })
    }


  }
  ngOnInit() {
  }

}
