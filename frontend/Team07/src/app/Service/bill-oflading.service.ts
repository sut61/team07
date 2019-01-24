import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable()
export class BillOfladingService   {

  public API = '//localhost:8081';
  bill_of_lading: any;
  constructor(private http: HttpClient) {
  }
  getdata(bill,id,callback){
    this.http.get(this.API + '/Bill_of_lading-list/'+id).subscribe(data =>{
      this.bill_of_lading = data;
      return callback && callback();
    })

  }
  
 
  
    
}
  

