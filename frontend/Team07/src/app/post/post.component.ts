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
    this.httpClient.post('http://localhost:8080/ShowHrs-insert/staff/' + this.emp.staffSelect + '/department/' + this.emp.departmentSelect + '/worktime/' + this.emp.worktimeSelect+ '/Note/' + String(this.detail.note), this.emp)
      .subscribe(
        data => { console.log('PUT Request is successful', data); },
        error => { console.log('Error', error); }
      );
  }
}







