import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

 

  Customersumbit(initalId: number, name: string, genderId: number, bloodTypeId: number, address: string, phonenumber: string, username: string, password: string): Observable<any> {
    console.log(this.API + '/Customer-insert/InitalId/' + initalId + '/Name/' + name + '/GenderId/' + genderId + '/BloodType/' + bloodTypeId + '/Address/' + address + '/Phonenumber/' + phonenumber + '/Username/' + username + '/Password/' + password)
    return this.http.post(this.API + '/Customer-insert/InitalId/' + initalId + '/Name/' + name + '/GenderId/' + genderId + '/BloodType/' + bloodTypeId + '/Address/' + address + '/Phonenumber/' + phonenumber + '/Username/' + username + '/Password/' + password, {});
  }


  getInitials(): Observable<any> {
    return this.http.get(this.API + '/Initial-list');
  }
  getGenders(): Observable<any> {
    return this.http.get(this.API + '/Gender-list');
  }
  getBloodTypes(): Observable<any> {
    return this.http.get(this.API + '/BloodType-list');
  }
}