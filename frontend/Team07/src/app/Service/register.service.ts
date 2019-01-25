import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  public API = '//localhost:8080';
  
  constructor(private http: HttpClient) {}

  getInitials(): Observable<any> {
    return this.http.get(this.API + '/Initial-list');
  }
  getGenders(): Observable<any> {
    return this.http.get(this.API + '/Gender-list');
  }
  getBloodTypes(): Observable<any> {
    return this.http.get(this.API + '/BloodType-list');
}
Customersumbit(initalId: number, genderId: number, bloodTypeId: number,name: string,address: string,phonenumber: string,username: string,password: string): Observable<any> {
  
  //console.log(this.API + '/Customer-insert' +  'initalId/' + initalId+ 'genderId/' +genderId+ 'bloodTypeId/' +bloodTypeId+ 'name/' +name+ 'address/' +address+'phonenumber/'+phonenumber+'username/'+username+'password/'+password)
  return this.http.post(this.API + '/Customer-insert' +  '/initalId/' + initalId+ '/genderId/' +genderId+ '/bloodTypeId/' +bloodTypeId+ '/names/' +name+ '/address/' +address+'/phonenumber/'+phonenumber+'/username/'+username+'/password/'+password, {});
  }
}