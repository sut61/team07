import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  public API = '//localhost:8080';
  
  constructor(private http: HttpClient) {}

  getCategory(): Observable<any> {
    return this.http.get(this.API + '/Stroage-Category');
  }
  
}
