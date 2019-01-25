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
}