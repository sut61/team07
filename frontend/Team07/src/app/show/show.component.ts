import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import { HttpClient} from '@angular/common/http';
@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.css']
})
export class ShowComponent implements OnInit {

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
