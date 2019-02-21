import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  public API = '//localhost:8080';

  constructor(private http: HttpClient) {}

  getOrders(): Observable<any> {
    return this.http.get(this.API + '/Orders-list');
  }



  PostOrders(nameorders: string, partnersId: number, catalogId: number,drugId :number,staff :string, amount: Number): Observable<any> {

    console.log(this.API + '/Orders-insert/nameorders/' + nameorders + '/partnersId/' + partnersId + '/catalogId/' + catalogId + '/amount/' + amount)
    return this.http.post(this.API + '/Orders-insert/nameorders/' + nameorders + '/partnersId/' + partnersId + '/catalogId/' + catalogId + '/drugId/' + drugId + '/staff/' + staff +'/amount/' + amount,{});

  }
}
