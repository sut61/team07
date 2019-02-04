import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
@Injectable()
export class DrugdataService {
  public API = '//localhost:8080';
  constructor(private http: HttpClient) { }

  DrugDataPost(detail: String, drugId: Number, staffId: Number, categoryId: Number, medicineId: Number): Observable<any> {
    console.log(this.API + '/Drugdata-insert/detail/' + detail + '/drugId/' + drugId + '/staffId/' + staffId + '/categoryId/' + categoryId + '/medicineId/' + medicineId)
    return this.http.post(this.API + '/Drugdata-insert/detail/' + detail + '/drugId/' + drugId + '/staffId/' + staffId + '/categoryId/' + categoryId + '/medicineId/' + medicineId, {});
  }

  MedicinePost(name: String): Observable<any> {
    return this.http.post(this.API + '/Medicine-insert/name/' + name,{});
  }

}
