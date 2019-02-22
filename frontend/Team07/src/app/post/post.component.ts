import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { PostService } from '../Service/post.service';
import { HttpClient } from '@angular/common/http';
import { AppserviceService } from '../Service/appservice.service';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})

export class PostComponent implements OnInit {
  staffs: Array<any>;
  departments: Array<any>;
  worktimes: Array<any>;
 
  count: 0;

  detail: any = {
    staff: '',
    department: '',
    worktime: '',
    note: '',

  };
  emp: any = {
    staffSelect: '',
    departmentSelect: '',
    worktimeSelect: ''
  };


  showdatainput() {
    console.log(this.detail)
  }


  names: any;
  public API = '//localhost:8080';
  staffdb: any = { staffId: Number, staffName: String, staffUser: String, staffPass: String, staffPhone: String, online: String }
status:any = {status:String}
  setstaffOfline() {
    this.app.setStaffOfline(Number(this.staffdb.staffId)).subscribe(data => {
      console.log(data);
    })
  }


  getStaffOnline() {
    return this.http.get(this.API + '/StaffOnline/' + "true");
  }

  constructor(private http: HttpClient, private app: AppserviceService, private router: Router, private postService: PostService, private httpClient: HttpClient) { }

  ngOnInit() {

    this.getStaffOnline().subscribe(data => {
      console.log(data);
      this.staffdb = data;
      this.names = this.staffdb.staffUser;
      console.log(this.names)
    })
    this.postService.getStaffs().subscribe(data => {
      this.staffs = data;
      console.log(this.staffs);
    });

    this.postService.getDepartments().subscribe(data => {
      this.departments = data;
      console.log(this.departments);
    });

    this.postService.getWorktimes().subscribe(data => {
      this.worktimes = data;
      console.log(this.worktimes);
    });
  }

  SubmitdData() {
    console.log(this.detail)
    const data = this.detail
    this.router.navigate(['show', {
      staff: data.staff,
      department: data.department,
      worktime: data.worktime,
      note: data.note,

    }])

  }

  save1() {

    let rs = /[A-Za-z ]{3,25}/;
    this.count = 0;
    //this.detail.addressSelect = this.addressselect;

    if (this.detail.staff === undefined || this.detail.staff === "" || this.detail.staff == null) {

      this.count = 0;
    } else {

      this.count += 1;
    }
    if (this.detail.department === undefined || this.detail.department === "" || this.detail.department == null) {

      this.count = 0;
    } else {

      this.count += 1;
    }
    if (this.detail.worktime === undefined || this.detail.worktime === "" || this.detail.worktime == null) {

      this.count = 0;
    } else {
      this.count += 1;
    }

    if (this.detail.note === undefined || this.detail.note === "" || this.detail.note == null) {

      this.count = 0;
    } else {
      this.count += 1;
    }


    // if (rs.test(this.detail.note)) {
    //   // this.count += 1;
    //   if (String(this.detail.note).length >= 25) {
    //     alert("พยัญชนะห้ามเกิน 25 ตัว")
    //   } else {
    //     this.count += 1;
    //   }
    //   if (rs.test(this.detail.note)) {
    //     // this.count += 1;
    //     if (String(this.detail.note).length <= 2) {
    //       alert("พยัญชนะมากกว่า 2 ตัวขึ้นไป")
    //     } else {
    //       this.count += 1;
    //     }

    //   } else {
    //     this.count = 0;
    //     alert("กรอกยอดสุทธิเป็นตัวเลขเท่านั้น")
    //   }
    // }

    if (this.count >= 4) {
      this.httpClient.post('http://localhost:8080/ShowHrs-insert/staff/' + this.emp.staffSelect + '/department/' + this.emp.departmentSelect + '/worktime/' + this.emp.worktimeSelect + '/Note/' + String(this.detail.note), this.emp)
        .subscribe(datas => {
          this.status = datas;
          alert( this.status.status)
          //console.log('PUT Request is successful', datas);
        }
        );

      //   this.SubmitdData();

    } else {
     
      alert("กรุณากรอกข้อมูลให้ครบถ้วน")
    }
  }
}







