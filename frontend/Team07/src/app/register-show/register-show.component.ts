import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
@Component({
  selector: 'app-register-show',
  templateUrl: './register-show.component.html',
  styleUrls: ['./register-show.component.css']
})
export class RegisterShowComponent implements OnInit {

  data:any={}
  constructor(private route:ActivatedRoute) { }

  ngOnInit() {

    this.route.params.subscribe(prams=>{
      this.data = prams
      console.log(prams)
    })
  }

}