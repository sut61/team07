import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MedicineService {
  public API = '//localhost:8080';
  constructor(private http: HttpClient) {}
  getMedicine(): Observable<any> {
    return this.http.get(this.API + '/Medicine');
  }
}
