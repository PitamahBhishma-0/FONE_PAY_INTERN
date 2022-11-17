import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})

export class LoginserviceService {
  private baseUrl:String="http://localhost:8080"

  constructor(private httpClient: HttpClient) { }
  tokenResponse :any;
  generateToken(credentials:any){
    return this.httpClient.post(`${this.baseUrl}/auth/login/`,credentials)
  }

  loginUser(token:string){
    sessionStorage.setItem("token",token)
  }
  isLoggedIn(){
    let token=sessionStorage.getItem("token");
    if(token==undefined||token==''||token==null){
      return false;
    }
    else {
      return true;
    }
  }

  logOut(){
    alert("Your session expired");
    sessionStorage.removeItem("token");
  }
  getToken(){
    return sessionStorage.getItem("token");
  }
   getRoleByToken(token:any){
    let _token=token.split('.')[1];
    this.tokenResponse=JSON.parse(atob(_token));
    let roles:string[]=[];
     console.log(this.tokenResponse.role);
     for(const tokenResponse of this.tokenResponse.role){
       console.log(tokenResponse.authority);
       roles.push(tokenResponse.authority);
     }
     return roles;
   }


}
