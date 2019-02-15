import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class DrugService {

  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getDrug(): Observable<any> {
    return this.http.get(this.API + '/Stroage-drug');
  }

  getDrugById(drugId:Number): Observable<any> {
    return this.http.get(this.API + '/Drug/' +  drugId);
  }
}
