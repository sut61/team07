import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AppserviceService } from "../Service/appservice.service";
import { HttpClient } from "@angular/common/http";
@Component({
  selector: "app-login-staff",
  templateUrl: "./login-staff.component.html",
  styleUrls: ["./login-staff.component.css"]
})
export class LoginStaffComponent implements OnInit {
  credentials = { username: "", password: "",staffname:'',staffId:'' };
   staff:{staffId:'',staffName:'',staffUser:'',staffPass:'',staffphone:'',staffonline:false}
  data:any ={}
  constructor(
    private app: AppserviceService,
    private router: Router,
    private http: HttpClient
  ) {}

  loginstaff() {
    console.log(this.credentials);
    if (this.credentials.username === "" || this.credentials.password === "") {
      alert("please Enter usernaem or pass");
    } else {
      this.app.authenticate2(this.credentials, () => {
        if (this.app.authenticated2) {
          this.data = this.app.getUser();
          console.log(this.data)
          this.router.navigate(["home",{staffId:this.data.staffId,staffName:this.data.staffName,staffPass:this.data.staffPass,staffPhone:this.data.staffPhone,staffUser:this.data.staffUser}]);
        } else {
          //  alert('not user')
          alert("No User ");
        }
      });
    }
  }

  // logoutstaff(){
  //   this.credentials.staffId = this.app.getId();
  //   this.app.setStaffOfline(Number(this.credentials.staffId)).subscribe(data => {
  //     console.log(data);
  //   });

  // }
  ngOnInit() {}
}
