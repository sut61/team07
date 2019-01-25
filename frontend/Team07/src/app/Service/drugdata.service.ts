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

  sumbittyDrug(drugId: number, namedrug: string): Observable<any> {
    console.log('namedrug = ')
    console.log(namedrug)
    console.log(this.API + '/Drug-insert/' +  drugId +'/name/' + namedrug)
    return this.http.post(this.API + '/Drug-insert/' +  drugId +'/name/' + namedrug, {});
  }
  
}
