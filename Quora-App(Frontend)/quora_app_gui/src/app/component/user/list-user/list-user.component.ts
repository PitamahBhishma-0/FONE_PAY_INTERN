import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {UserServiceService} from "../../services/user-service.service";
import {Router} from "@angular/router";
import {catchError, Observable, of as observableOf} from "rxjs";
import {MatTableDataSource} from "@angular/material/table";
import {LoginserviceService} from "../../services/loginservice.service";
import {DownloadExcelService} from "../../services/download-excel.service";
import {HttpClient} from "@angular/common/http";
import * as FileSaver from "file-saver";
import {saveAs} from "file-saver";

import Swal from "sweetalert2";
import {User} from "../../../model/registration";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-list-user',
  templateUrl: './list-user.component.html',
  styleUrls: ['./list-user.component.css']
})
export class ListUserComponent implements OnInit {
  displayUpdate = null;
  user: any;
  users:User[]=[];
  filters={
    keyword:''
  }

  currentRole: any;
  baseUrl = "http://localhost:8080/users/download/users.xlsx"
  constructor(private userService: UserServiceService, private router: Router,
              private loginService: LoginserviceService,private download:DownloadExcelService
  ,private http:HttpClient) {
  }
  ngOnInit(): void {
   // this.getData(this.user);
    console.log("Get all User initiated ");
    console.log(this.displayUpdate)
    this.currentRole = this.loginService.getRoleByToken(this.loginService.getToken());
    this.displayUpdate = this.currentRole.includes('ADMIN', 'MODERATOR');
    console.log(this.displayUpdate)
    console.log(this.currentRole.includes('ADMIN', 'MODERATOR'));
    this.user = this.userService.getAllUser();
    console.log(this.users)
  }

  listUsers(){

    this.userService.getAllUser().subscribe(
      // @ts-ignore
      data=>this.users=this.filterUsers(data)
    );

  }
  filterUsers(users:User[]){
    return users.filter((e)=>{
    return e.name.toLowerCase().includes(this.filters.keyword.toLowerCase())
  });
  }

 /*
  getData(user:User){
    this.userService.getData(user).subscribe(
      response=>{
        this.data=response;
        console.log(response)
      },
      error=>{
        console.log("error while getting user details")
      }
    );
  }
  searchForm(searchInfo:any){
   this.user.name=this?.Name?.value;
   this.user.email=this?.Email?.value;1234567890123456
 }

 get Name(){
   return this.form.get('name');
 }

 get Email(){
    return this.form.get('email');

 }*/
  updateEmployee(id: number) {
    this.router.navigate(['dashboard', id]);
  }

  deleteUser(id:number){
    this.userService.deleteUser(id).subscribe(
      res=>{
        Swal.fire('USER DELETED','User successfully deleted of id :'+id,'warning')
        this.router.navigate(['dashboard'])
      }
      ,
      error => {
        Swal.fire('Error','error in deleting User with id :'+id,'error')
      }
    )
  }

  logoutUser() {
    this.loginService.logOut();
    this.router.navigate(['/login'])
  }


  downloadFile(){
   this.http.get<any> (this.baseUrl).subscribe(
     data=>{
       console.log(data)
      this.download.generateExcel(data);
     },
     error => {
       console.log("error in here")
       console.log(error)
     }
   )
  }



}






