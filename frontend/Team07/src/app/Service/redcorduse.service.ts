import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RedcorduseService {

  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  postRedcorduse(symptom: String, drugdataId: Number, staffId: Number, customerId: Number): Observable<any> {
    console.log(this.API + '/RecordDrugUse-insert/symptom/' + symptom + '/drugdataId/' + drugdataId + '/staffId/' + staffId + '/customerId/' + customerId)
    return this.http.post(this.API + '/RecordDrugUse-insert/symptom/' + symptom + '/drugdataId/' + drugdataId + '/staffId/' + staffId + '/customerId/' + customerId, {});

  }



  getCustomerById(customerId: number): Observable<any> {
    return this.http.get(this.API + '/Customer/' + customerId);
  }

  getCustomerByname(customerName: String): Observable<any> {
    return this.http.get(this.API + '/Customer/customerName/' + customerName);
  }


  
  getRedcorduseAll(): Observable<any> {
    return this.http.get(this.API + '/RecordDrugUse-list/');
  }





}
