import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable() 



export class AppserviceService {
  public API = '//localhost:8081';
  authenticated = false;
  user : any;
  public name: any =''
  public auth : boolean
  constructor(private http: HttpClient) {
  }
  authenticate(credentials, callback){
    this.http.post(this.API+'/User-list/0/'+credentials.username+'/pass/'+credentials.password,{}).subscribe(data=>{
     // console.log(credentials)
        if(data['success']){
            this.authenticated = true
            this.user = data['user']
            this.name = data['user'].name
            localStorage.setItem('user',JSON.stringify(this.user))
        }else{
            this.authenticated = false
        }
        return callback && callback();  
    })
  }
  getUser():any{
   return this.user;
  }
  setUser(user:any){
      this.user = user;
  }
  setAuth(auth : boolean){
      this.auth = auth
  }
  getAuth(): boolean{
     return this.auth
  }


}
