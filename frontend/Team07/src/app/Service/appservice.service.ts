import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from 'rxjs';
@Injectable()
export class AppserviceService {
  public API = "//localhost:8080";
  authenticated2 = false;
  user: any;
  staffId:any;
  public name: any = "";
  public auth: boolean;

  constructor(private http: HttpClient) {}

  authenticate2(credentials, callback) {
    this.http.post( this.API + "/Staff/Staffuser/" + credentials.username + "/staffpassword/" +  credentials.password,{}).subscribe(data => {
        // console.log(credentials)
        if (data["success"]) {
          this.authenticated2 = true;
          this.user = data["user"];
          this.name = data["user"].staffName;
          this.staffId = data["user"].staffId;
          localStorage.setItem("staffId", JSON.stringify(this.staffId));
         console.log(this.staffId);
        } else {
          this.authenticated2 = false;
        }
return callback && callback();
});
}


  setStaffOnline(staffId:Number): Observable<any> {
    return this.http.post(this.API + '/Staff/StaffOnline/{onlineId}' + staffId,{});
  }


  setStaffOfline(onlineId:Number): Observable<any> {
    return this.http.post(this.API + '/Staff/StaffOffline/{onlineId}' + onlineId,{});
  }



getId():any{
  return this.staffId;
}
  getUsername(): any {
    return this.name;
  }
  setUser(user: any) {
    this.user = user;
  }
  setAuth(auth: boolean) {
    this.auth = auth;
  }
  getAuth(): boolean {
    return this.auth;
  }
}





