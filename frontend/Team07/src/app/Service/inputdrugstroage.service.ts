import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
@Injectable()
export class InputdrugstroageService {
  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  sumbittyDrug(drugId: number, namedrug: string): Observable<any> {
    console.log('namedrug = ')
    console.log(namedrug)
    console.log(this.API + '/Drug-insert/' +  drugId +'/name/' + namedrug)
    return this.http.post(this.API + '/Drug-insert/' +  drugId +'/name/' + namedrug, {});
  }


  sumbittycategory(categoryId: number, categoryname: string): Observable<any> {
    console.log('categoryname = ')
    console.log(categoryname)
    console.log(this.API + '/Category-insert/' +  categoryId +'/name/' + categoryname)
    return this.http.post(this.API + '/Category-insert/' +  categoryId +'/categoryname/' + categoryname, {});
  }

  summbituyPrescription(preId: number, nameprescription: string): Observable<any> {
    console.log('nameprescription = ')
    console.log(nameprescription)
    console.log(this.API + '/Prescription-insert/' +  preId +'/nameprescription/' + nameprescription)
    return this.http.post(this.API + '/Prescription-insert/' +  preId +'/nameprescription/' + nameprescription, {});
  }
}
