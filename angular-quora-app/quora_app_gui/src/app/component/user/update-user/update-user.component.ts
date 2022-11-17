import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Observable} from "rxjs";
import {UserServiceService} from "../../services/user-service.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {ActivatedRoute, Router} from "@angular/router";
import {startWith} from "rxjs/operators";
import {AuthService} from "../../services/auth.service";
import {error} from "@angular/compiler-cli/src/transformers/util";
import Swal from 'sweetalert2';
import {User} from "../../../model/registration";
import {LoginserviceService} from "../../services/loginservice.service";
@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})

export class UpdateUserComponent implements OnInit {

  // @ts-ignore
  users: User;
  // @ts-ignore
  id:number;
  currentRole:any;
  constructor(private _route:ActivatedRoute,private userService:UserServiceService,private route :Router) {
  }
  ngOnInit(): void {
    this.users=new User();
    this.id= this._route.snapshot.params['id'];
    //alert(this.id);
    this.userService.getUserById(this.id).subscribe(
      (data :any)=>{
        this.users=data
        console.log(data)
        console.log(this.id)
        console.log("this is user by id"+this.users);

      },
      error=>{
        console.log(error)
      }
    )

  }
updateSubmit(){

  this.userService.updateUser(this.id,this.users).subscribe(
    data=> {
      console.log(data + "is clicked"),

          Swal.fire('SUCCESS !!','user updated user','success');

    }
    ,
    error=>{
      console.log(error+"is error")
           Swal.fire('Error','error in updating','error')

    });
  this.users=new User();
  this.route.navigate(['/dashboard/getUsers']);




}


}
