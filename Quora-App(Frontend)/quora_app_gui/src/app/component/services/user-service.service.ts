import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../../model/registration";

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
  private baseUrl: String = "http://localhost:8080/users";
  constructor(private http: HttpClient) {

  }

  getAllUser() {
    return this.http.get(`${this.baseUrl}/getAllUsers`);
  }

  getUserById(uid: number) {
    return this.http.get(`${this.baseUrl}/${uid}`);
  }

  updateUser(id:number,user: any) {
    return this.http.post(`${this.baseUrl}/update/${user.uid}`,user);
  }

  deleteUser(id:number){
    return this.http.delete(`${this.baseUrl}/delete/${id}`);
  }

  getData(user:User){
    let url=this.baseUrl+"/search";
    return this.http.post(url,user);
  }
}
