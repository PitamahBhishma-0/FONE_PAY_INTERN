import { Injectable } from '@angular/core';
import {Subject} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {User} from "../../model/registration";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  public loginStatus = new Subject<boolean>;
  public baseUrl=environment.baseUrl;
  constructor(private http:HttpClient) {

  }







  logOut() {
    console.log('local clear')
    sessionStorage.clear();
    this.loginStatus.next(false);
    return true;
  }


  isAdmin() {
    if (sessionStorage.getItem('roles')) {
      return !!(JSON.parse(sessionStorage.getItem('roles')!).includes('ADMIN'));
    }
    return false;
  }
}

