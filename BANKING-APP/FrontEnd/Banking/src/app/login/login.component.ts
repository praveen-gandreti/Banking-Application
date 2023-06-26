import { Component } from '@angular/core';
import {FormGroup,FormControl,Validators} from '@angular/forms'
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ServiceService } from '../service.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  hide=true
  loginUser:any
  errorMessage:any
  constructor(private router:Router,private toster:ToastrService,private service:ServiceService)
  {

  }
  form=new FormGroup({
    userName:new FormControl(null,[Validators.required,Validators.pattern("[a-zA-Z0-9/.@]+")]),
    password:new FormControl(null,[Validators.required,Validators.pattern("[a-zA-Z0-9]+")])
  })

  // VALIDATING WITH USER CREDENTIALS
  login()
  {
      if(this.form.valid)
      {
          let formdata:any=this.form.value
          console.log(this.form.value.password)
          this.service.loginWithUserData(this.form.value.userName).subscribe((d)=>{
            this.loginUser=d;
            console.log(this.loginUser.password)
            console.log(formdata.password)
            if(this.loginUser.password==formdata.password)
            {
              sessionStorage.setItem("role",this.loginUser.role)
              sessionStorage.setItem("loginId",this.loginUser.userName)
              sessionStorage.setItem("account",this.loginUser.account)
              this.service.noticeAll()
              this.toster.success(this.loginUser.role.toUpperCase()+" LOGIN SUCCESSFULL")
            }
            else
            {
              this.toster.warning("Wrong Password")
            }
          },
          (error)=>{
            this.errorMessage=error
            this.toster.warning(this.errorMessage.error)
          })
        this.form.reset()
      }
      else
      {
        this.toster.warning("Please Enter Credentials")
      }
    
  }

  // CALLING REGISTRATION PAGE
  create()
  {
    this.router.navigate(["registration"])
  }

}
