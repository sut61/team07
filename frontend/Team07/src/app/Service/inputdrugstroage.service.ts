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

  // sumbittyDrug(drugId: number, namedrug: string): Observable<any> {
  //   console.log('namedrug = ')
  //   console.log(namedrug)
  //   console.log(this.API + '/Drug-insert/' +  drugId +'/name/' + namedrug)
  //   return this.http.post(this.API + '/Drug-insert/' +  drugId +'/name/' + namedrug, {});
  // }





  summbituyPrescription(nameprescription: string, amountout: string, categoryId: number, DrugId: number, staff: string): Observable<any> {

    //console.log(this.API + '/Prescription-insert/nameprescription/' + nameprescription + '/CategoryId/' + categoryId + '/DrugId/' + DrugId + '/staffId/' + staffId)
    return this.http.post(this.API + '/Prescription-insert/nameprescription/' + nameprescription + '/amountout/' + amountout + '/CategoryId/' + categoryId + '/DrugId/' + DrugId + '/staff/' + staff, {});

  }

  updateDrug(drugId: number, drugname: string, drugprice: number, drugqty: number): Observable<any> {
    console.log(this.API + '/Drug-Update/' + drugId + '/name/' + drugname + '/price/' + drugprice + '/qty/' + drugqty);
    return this.http.post(this.API + '/Drug-Update/' + drugId + '/name/' + drugname + '/price/' + drugprice + '/qty/' + drugqty, {});
  }


}
