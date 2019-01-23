import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import { AppserviceService } from '../Service/appservice.service';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-loginuser',
  templateUrl: './loginuser.component.html',
  styleUrls: ['./loginuser.component.css']
})
export class LoginUserComponent implements OnInit {
  credentials = {username: '', password: ''};
  constructor(private app:AppserviceService ,private router: Router, private http: HttpClient) {}

  ngOnInit() {
  }

  LoginSubmit(){
    if(this.credentials.username === '' ||this.credentials.password ==='' ){
  alert('please Enter usernaem or pass')
    }else{
      this.app.authenticate(this.credentials,()=>{
        if(this.app.authenticated){
          
         this.router.navigate(['home',{name:this.credentials.username,pass:this.credentials.password}]);
        }else{
         //  alert('not user')
        alert('No User ')
        }
      })
    }
    
   
  }

}
