import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable() 



export class AppserviceService {
  public API = '//localhost:8080';
  authenticated = false;
  authenticated2 = false;
  user : any;
  public name: any =''
  public auth : boolean
  constructor(private http: HttpClient) {
  }
  authenticate(credentials, callback){
    this.http.post(this.API+'/Customer/customeruserID/'+credentials.username+'/customerPassword/'+credentials.password,{}).subscribe(data=>{
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

  authenticate2(credentials, callback){
    this.http.post(this.API+'/Staff/Staffuser/'+credentials.username+'/staffpassword/'+credentials.password,{}).subscribe(data=>{
     // console.log(credentials)
        if(data['success']){
            this.authenticated2 = true
            this.user = data['user']
            this.name = data['user'].name
            localStorage.setItem('user',JSON.stringify(this.user))
        }else{
            this.authenticated2 = false
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
