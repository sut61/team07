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
          this.credentials.staffname = this.app.getUsername();

          this.credentials.staffId = this.app.getId();
          this.router.navigate(["home",{username:this.credentials.staffname,staffId: this.credentials.staffId}]);
        } else {
          //  alert('not user')
          alert("No User ");
        }
      });
    }
  }
  ngOnInit() {}
}
