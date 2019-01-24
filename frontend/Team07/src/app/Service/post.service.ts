import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  public API = '//localhost:8080';
  
  constructor(private http: HttpClient) {}

  getStaffs(): Observable<any> {
    return this.http.get(this.API + '/Staff-list');
  }
  getDepartments(): Observable<any> {
    return this.http.get(this.API + '/Department-list');
  }
  getWorktimes(): Observable<any> {
    return this.http.get(this.API + '/Worktime-list');
  }
}