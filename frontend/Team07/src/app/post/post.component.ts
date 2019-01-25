import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { PostService } from '../Service/post.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})

export class PostComponent implements OnInit {
  staffs: Array<any>;
  departments: Array<any>;
  worktimes: Array<any>;

  data: any = {
    staff:'',
    department:'',
    worktime:''
  };
  emp: any = {
    staffSelect: '',
    departmentSelect: '',
    worktimeSelect: ''
  };


  showdatainput() {
    console.log(this.data)
  }
  constructor(private router:Router,private postService: PostService, private httpClient: HttpClient) { }

  ngOnInit() {
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

  SubmitdData(){
    console.log(this.data)
    const data  = this.data
      this.router.navigate(['show',{
        staff:        data.staff,
        department:     data.department,
        worktime:        data.worktime,
        }])
 
  }

  save() {
    this.httpClient.post('http://localhost:8080/Customer/' + this.data.staff + '/' + this.data.department + '/' + this.data.worktime  ,this.data)
    .subscribe(
      data =>   {console.log('PUT Request is successful', data);},
      error =>  {console.log('Error', error);}
      );
    }
}







