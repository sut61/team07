import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable()
export class ProductService {
  public API = '//localhost:8080';
  // public MAP = this.API +'/mapdata/'

 /* public Bill_path = this.API + '/Bill_of_lading-insert/'
  public product_path = this.API + '/Product-insert/'
  public typeproduct_path = this.API + '/TypeProduct-insert/'
 */

  public Staff_path = this.API + '/Staff-insert/'


  bill_of_lading: any = {}

  constructor(private http: HttpClient) {

  }

 /* submitBillLading(billId: number): Observable<any> {
    

    return this.http.post(this.Bill_path + billId, {});


  }

  sumbitproduct(productId: number, nameproduct: string, price: number, qty: number): Observable<any> {
    console.log('price = ')
    console.log(price)
    console.log(this.product_path + productId + '/name/' + nameproduct + '/price/' + price + '/qty/' + qty)
    return this.http.post(this.product_path + productId + '/name/' + nameproduct + '/price/' + price + '/qty/' + qty, {});
  }

  sumbittyproduct(typeproductId: number, nametype: string): Observable<any> {
    console.log('nametype = ')
    console.log(nametype)
    console.log(this.typeproduct_path + typeproductId + '/nametype/' + nametype)
    return this.http.post(this.typeproduct_path + typeproductId + '/nametype/' + nametype, {});
  }
  */
  sumbittuser(staffName:string,staffPhone:string,staffAddress:string,staffUserID:string,staffPassword:string): Observable<any> {
console.log()
    return this.http.post(this.Staff_path  + '/staffName/' + staffName +'/staffPhone/' + staffPhone + '/staffAddress/' + staffAddress  + '/staffUserID/' + staffUserID + '/staffPassword/' + staffPassword,{});
    

  }

  /*
  sumbituser(billId: String, product: object): Observable<any> {

    return this.http.post(this.SUBMIT + billId + '/Product/' + product, {});

  }
*/
  getdata(bill, callback) {
    this.http.get(this.API + '/Bill_of_lading-list').subscribe(data => {
      this.bill_of_lading = data;
      return callback && callback();
    })

  }

}
