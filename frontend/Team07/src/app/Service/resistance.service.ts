import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ResistanceService {

  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  postResistance(recordDrugUseId: Number, resist: String): Observable<any> {
    console.log(this.API + '/Resistance-insert/recordDrugUseId/' + recordDrugUseId + '/resist/' + resist );

    return this.http.post(this.API + '/Resistance-insert/recorddrugId/' + recordDrugUseId + '/resist/' + resist, {});


  }

  getRecordDrugUseById(recordDrugUseId: number): Observable<any> {
    return this.http.get(this.API + '/RecordDrugUseId/' + recordDrugUseId);
  }



}
