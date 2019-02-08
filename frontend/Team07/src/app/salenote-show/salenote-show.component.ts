import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import { HttpClient} from '@angular/common/http';
@Component({
  selector: 'app-salenote-show',
  templateUrl: './salenote-show.component.html',
  styleUrls: ['./salenote-show.component.css']
})
export class SalenoteShowComponent implements OnInit {

  data:any={}

  constructor(private route:ActivatedRoute, private httpClient: HttpClient) { }
  SumbitRegister(){
    alert('register !!!')
  }

  ngOnInit() {
    this.route.params.subscribe(prams=>{
      this.data = prams
      console.log(prams)
    })
  }

}
