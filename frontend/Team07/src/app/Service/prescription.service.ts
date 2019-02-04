import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class PrescriptionService {

  public API = '//localhost:8080';
  constructor(private http: HttpClient) { }

  getPrescription(): Observable<any> {
    return this.http.get(this.API + '/Stroage-prescription');
  }

}
