import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute, RouterLink } from "@angular/router";
@Component({
  selector: 'app-select-warehouse',
  templateUrl: './select-warehouse.component.html',
  styleUrls: ['./select-warehouse.component.css']
})
export class SelectWarehouseComponent implements OnInit {
  data:any={}
  user : any = {}


  ngOnInit() {

    this.route.params.subscribe(prams=>{
      this.user = prams
      console.log(this.user)
    })
  }
  constructor(private router:Router,private route: ActivatedRoute) { }
 
  Bill(){
  //  console.log(this.data)
    this.router.navigate(['bill'])
  }

  Saveproduct(){
   // console.log(this.data)
    this.router.navigate(['product',this.user])
  }
  logout(){
   // console.log(this.data)
    this.router.navigate([''])
  }
  

}
