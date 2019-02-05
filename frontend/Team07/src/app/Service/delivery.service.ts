import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DeliveryService {
  public API = '//localhost:8080';

  constructor(private http: HttpClient) {}

  Deliverysumbit(staffId: number, customerId: number, drugId: number, amount: string, netamount: string): Observable<any> {
    console.log(this.API + '/Delivery-insert/StaffId/' + staffId + '/CustomerId/' + customerId + '/DrugId/' + drugId + '/Amount/' + amount + '/Netamount/' + netamount)
    return this.http.post(this.API + '/Delivery-insert/StaffId/' + staffId + '/CustomerId/' + customerId + '/DrugId/' + drugId + '/Amount/' + amount + '/Netamount/' + netamount, {});
  }


  getStaffs(): Observable<any> {
    return this.http.get(this.API + '/Staff-list');
  }
  getCustomers(): Observable<any> {
    return this.http.get(this.API + '/Customer-list');
  }
  getDrugs(): Observable<any> {
    return this.http.get(this.API + '/Stroage-drug');
  }
  // Delivery(initalId: number, name: string, genderId: number, bloodTypeId: number, address: string, phonenumber: string, username: string, password: string): Observable<any> {
  //   console.log(this.API + '/Customer-insert/InitalId/' + initalId + '/Name/' + name + '/GenderId/' + genderId + '/BloodType/' + bloodTypeId + '/Address/' + address + '/Phonenumber/' + phonenumber + '/Username/' + username + '/Password/' + password)
  //   return this.http.post(this.API + '/Customer-insert/InitalId/' + initalId + '/Name/' + name + '/GenderId/' + genderId + '/BloodType/' + bloodTypeId + '/Address/' + address + '/Phonenumber/' + phonenumber + '/Username/' + username + '/Password/' + password, {});
  // }
}
