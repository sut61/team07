import { Component, OnInit, ViewChild } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';
import { HttpClient, HttpParams } from '@angular/common/http';
import { MatTable } from '@angular/material';
import { StaffService } from 'src/app/Service/staff.service';
import { Observable } from 'rxjs';
import { DataSource } from '@angular/cdk/table';

@Component({
  selector: 'app-salenote',
  templateUrl: './salenote.component.html',
  styleUrls: ['./salenote.component.css']
})
export class SalenoteComponent implements OnInit {

  public API = '//localhost:8080';
  drug: Array<any>;
  drugselect = '';
  status;
  count: 0;
  ggid: any;

  displayedColumns = ['item', 'amount', 'cost'];
  transactions = [];
  currentSalenote;
  data: any = {}

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

  ReceiptPost(orderreceiptId: Number, staffId: Number, drugId: Number, dates: String, noBill: String): Observable<any> {
    return this.http.post(
      this.API + '/Receipt-insert/orderreceiptId/' + orderreceiptId + '/staffId/' + staffId + '/drugId/' + drugId + '/dates/' + dates + '/noBill/' + noBill, {});
  }

  OrderReceiptPost(amount: Number): Observable<any> {
    return this.http.post(
      this.API +
      "/OrderRecipt-insert/amount/" + amount,
      {}
    );
  }

  ggez() {

    let re = /(^M{1})(\d{7,10}$)/g
    let rs = /[d{0-9}$]/;
    let rt = /[0-9]{1,2}\s(กุมภาพันธ์|มกราคม|มีนาคม|เมษายน|พฤษภาคม|มิถุนายน|กรกฎาคม|สิงหาคม|กันยายน|ตุลาคม|พฤษจิกายน|ธันวาคม)\s[0-9]{2,4}/
 
    this.count = 0;

    if (this.data.Receipt === undefined || this.data.Receipt === null) {
      this.count = 0;
    } else {
      this.count += 1;
    }
    if (this.drugselect === undefined || this.drugselect === null || this.drugselect === "") {
      this.count = 0;
    } else {
      this.count += 1;
    }
    if (this.data.Amount === undefined || this.data.Amount === null) {
      this.count = 0;
    } else {
      this.count += 1;
    }
    if (this.data.Date === undefined || this.data.Date === null) {
      this.count = 0;
    }
    else {
      if(rt.test(this.data.Date)){
        this.count += 1;
      }else{
        this.count = 0;
        alert("ใส่เป็นเดือน เช่น 14 กุมภาพันธ์ 2562")
      }
      if (rs.test(this.data.Amount)) {
        this.count += 1;

      } else {
        this.count = 0;
        alert("ใส่เป็นตัวเลขเท่านั้น")
      }

    }
    if (this.count >= 5) {

      if (re.test(this.data.Receipt)) {
        this.OrderReceiptPost(this.data.Amount).subscribe(data => {
          console.log(data)
        })

        this.ReceiptPost(Number(this.ggid + 1), Number(this.ggid), Number(this.drugselect), String(this.data.Date), String(this.data.Receipt)).subscribe(data => {
          // console.log(data)
          if (data.status == "save") {
            alert("บันทึกสำเร็จ")
          } else {
            alert("บันทึกไม่สำเร็จ")
          }
        })

      } else {
        alert("ตัวแรกต้องเป็น M และตามด้วยหมายเลข  7-10 ตัว ");
      }
    } else {
      alert("กรุณากรอกข้อมูลให้ครบถ้วน")
    }


    // console.log("no bill", this.data.Receipt)
    // console.log("drug", this.drugselect)
    // console.log("amount", this.data.Amount)
    // console.log("Dates", this.data.Date)




    // this.ReceiptPost(this.data.Receipt).subscribe(bill =>){
    //   console.log(bill)
    // }
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
    this.getDrug().subscribe(data => {
      this.drug = data;
      console.log(data)

    })
    this.getReceiptAll().subscribe(data => {
      this.ggid = data.length;
      console.log(data.length)
    })
  }

  getTotalCost() {
    return this.transactions.map(t => t.cost).reduce((acc, value) => acc + value, 0);
  }


  getDrug(): Observable<any> {
    return this.http.get(this.API + '/Stroage-drug');
  }


  getReceiptAll(): Observable<any> {
    return this.http.get(this.API + '/Receipt-list/');
  }




}
