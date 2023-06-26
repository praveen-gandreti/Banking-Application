import { Component } from '@angular/core';
import {FormGroup,FormControl,Validators} from '@angular/forms'
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ServiceService } from '../service.service';
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {

  constructor(private router:Router,private toster:ToastrService,private service:ServiceService)
  {

  }
  form=new FormGroup({
      firstName: new FormControl(null,[Validators.required,Validators.pattern("[a-zA-Z]+")]),
      lastName:new FormControl(null,[Validators.required,Validators.pattern("[a-zA-Z]+")]),
      address:new FormControl(null,[Validators.required,Validators.pattern("[a-zA-Z0-9]+")]),
      aadhar:new FormControl(null,[Validators.required,Validators.pattern("[0-9]+")]),
      phone:new FormControl(null,[Validators.required,Validators.pattern('[0-9]{10}')]),
      pan:new FormControl(),
      email:new FormControl(null,[Validators.required,Validators.pattern("[a-zA-Z0-9]+@[a-zA-Z]+\.[a-zA-Z]{2,}")]),
  })

  // ROUTING TO LOGIN PAGE
  backToLogin()
  {
    this.router.navigate(["login"])
  }

  // CREATING NEW ACCOUNT WITH FORM DATA
  createAccount()
  {
    if(this.form.valid)
    {
      this.service.newAccountRegistration(this.form.value).subscribe((d)=>{
        this.toster.success("success registration")
        this.form.reset()
        this.toster.info("Contact ADMIN To Get Access")
        this.router.navigate(["login"])
      },
      (error)=>{
          this.toster.warning(error)
      })
    }
    else
    {
      console.log(this.form.value)
      this.toster.warning("PLEASE ENTER VALID DATA")
    }
  }

}
