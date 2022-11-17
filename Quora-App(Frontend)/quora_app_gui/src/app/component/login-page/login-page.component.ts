import { Component, OnInit } from '@angular/core';
import {SignupService} from "../services/signup.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {LoginserviceService} from "../services/loginservice.service";
import {error} from "@angular/compiler-cli/src/transformers/util";
import Swal from "sweetalert2";

@Component({
  selector: 'login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  constructor(private loginService:LoginserviceService, private snak:MatSnackBar) { }

  ngOnInit(): void {
  }
   info= {
    email:"",
     password:""
   }
  doSubmit() {
    console.log("Form submitted")
    if(this.info.email!=''||this.info.password!=''){
          this.loginService.generateToken(this.info).subscribe(
            (response:any)=>{
              console.log(response);
              this.loginService.loginUser(response.token);
              window.location.href="/dashboard"
            },
            error=>{
              Swal.fire('Error','Username or password is incorrect','info')
            }


          )
    }
      else {
      this.snak.open("fields cannot be empty","OK");
      return ;
    }
  }
  }

