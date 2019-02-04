import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PartnersService {
  public API = '//localhost:8080';
  
  constructor(private http: HttpClient) {}

  getPartners(): Observable<any> {
    return this.http.get(this.API + '/Partners-list');
  }
}
