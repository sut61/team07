import { Component, OnInit, ViewChild } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';
import { HttpClient, HttpParams } from '@angular/common/http';
import { MatTable } from '@angular/material';
import { StaffService } from 'src/app/Service/staff.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-salenote',
  templateUrl: './salenote.component.html',
  styleUrls: ['./salenote.component.css']
})
export class SalenoteComponent implements OnInit {
  
  public API = '//localhost:8080';
  drug: Array<any>;
  drugselect = '';
  displayedColumns = ['item', 'amount', 'cost'];
  transactions = [];
  currentSalenote;
  data :any={}
  
  @ViewChild('myTable') myTable: MatTable<any>;

  onClickSubmit(body) {
    body.receipt = this.currentSalenote.id;
   console.log(body)
    this.http.post("http://localhost:8080/salenote/orders", body).subscribe(
      data => {
        console.log("POST Request is successful ", data);
         this.myTable.renderRows();
      },
      error => {
        console.log("Error", error);
      }
    );
  }
  constructor(private http: HttpClient, private staff: StaffService) {
  }

  ngOnInit() {

    //  this.http.post("http://localhost:8080/receipt/" + this.staff.getStaffId(), "").subscribe(
    //   data => {
    //     console.log("POST Request is successful ", data);
    //     this.currentSalenote = data;
    //     console.log(this.currentSalenote.id)
    //   },
    //   error => {
    //     console.log("Error", error);
    //   }

    // ); 
    this.getDrug().subscribe(data=>{
      this.drug = data;
      console.log(data)

    })
  }

  getTotalCost() {
    return this.transactions.map(t => t.cost).reduce((acc, value) => acc + value, 0);
  }

  
  getDrug(): Observable<any> {
    return this.http.get(this.API + '/Stroage-drug');
  }

}
