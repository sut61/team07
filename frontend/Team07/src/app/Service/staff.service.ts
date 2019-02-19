import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StaffService {
  
  constructor(private http: HttpClient) { }
  staff = JSON.parse(localStorage.getItem("staff"));

  public API = '//localhost:8080';

  public getStaff() :Object{
    return this.staff;
  }

  getStaffOnline(){
    return this.http.get(this.API + '/StaffOnline/' + "true" );
  }
 
  getStaffById(staffId: number): Observable<any> {
    return this.http.get(this.API + '/Staff/' + staffId);
  }
  public getStaffName() :String{
    console.log(this.staff)
    return this.staff.id;
  }
  //constructor() { }
}
