import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {SignupService} from "../services/signup.service";
import Swal from 'sweetalert2';
import {Router} from "@angular/router";

@Component({
  selector: 'signup-page',
  templateUrl: './signup-page.component.html',
  styleUrls: ['./signup-page.component.css']
})

export class SignupPageComponent implements OnInit {
  isLinear = true;
  infoForm=new FormGroup({
    name:new FormControl<any>("",Validators.required),
    email:new FormControl<any>("",Validators.required),
    password:new FormControl<any>("",Validators.required),
    phoneNumber:new FormControl<any>("",[Validators.required,Validators.pattern("^(\\+\\d{1,3}(-|\\s)?)?(9\\d{9})$")]),
    dob:new FormControl<any>("",Validators.required),
    experties:new FormArray([

      new FormControl("",Validators.required),new FormControl("",Validators.required),new FormControl("",Validators.required)
    ])
  });


  constructor(private services:SignupService,/*private step:StepsService*/
              private router :Router,private _formBuilder: FormBuilder) {

  }


  ngOnInit(): void {
  }


  doSubmit(){
    console.log("Form submitted");
    console.log(this.infoForm);
    this.services.signUp(this.infoForm.value).subscribe(

      response=>{
        Swal.fire('SUCCESS !!','user registered','success');
        console.log(response);
        this.router.navigate(['/dashboard']);      },
      error => {

        Swal.fire('Error', 'error in registering ', 'error')
     // this.router.navigate(['/dashboard']);
        console.log(this.infoForm);
        console.log(error);
      }
    )
  }

}


