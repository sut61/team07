import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StaffService {
  staff = JSON.parse(localStorage.getItem("staff"));

  public getStaff() :Object{
    return this.staff;
  }
  public getStaffId() :number{
    return this.staff.id;
  }
  public getStaffName() :String{
    console.log(this.staff)
    return this.staff.id;
  }
  //constructor() { }
}
