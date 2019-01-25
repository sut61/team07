import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";

import { RegisterService } from '../Service/register.service';

@Component({
  selector: 'app-register-show',
  templateUrl: './register-show.component.html',
  styleUrls: ['./register-show.component.css']
})
export class RegisterShowComponent implements OnInit {

  data:any={}
  constructor(private route:ActivatedRoute,private  app :RegisterService) { }
save(){
  this.app.Customersumbit(Number(1),Number(1),Number(1),String("jjj"),String("hhh"),String("ggg"),String("ff"),String("fff")).subscribe(data=>{
    console.log(this.data)
  })
}
  ngOnInit() {

    this.route.params.subscribe(prams=>{
      this.data = prams
      console.log(prams)
    })
  }

}