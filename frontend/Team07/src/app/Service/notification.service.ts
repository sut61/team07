import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {
  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  

  postNotification(cusId: Number, drugId: Number, timeEatId: Number, notificationName: String): Observable<any> {
    console.log(this.API + '/Notification-insert/customerId/' + cusId + '/drugId/' + drugId + '/timeEatId/' + timeEatId + '/notificationName/' + notificationName);

    return this.http.post(this.API + '/Notification-insert/customerId/' + cusId + '/drugId/' + drugId + '/timeEatId/' + timeEatId + '/notificationName/' + notificationName, {});


  }

  getCustomerById(customerId: number): Observable<any> {
    return this.http.get(this.API + '/Customer/' + customerId);
  }

  getCustomerByname(customerName: String): Observable<any> {
    return this.http.get(this.API + '/Customer/customerName/' + customerName);
  }



  getNotificationAll(): Observable<any> {
    return this.http.get(this.API + '/Notification-list');
  }
  getTimeEatAll(): Observable<any> {
    return this.http.get(this.API + '/TimeEat-list');
  }

}