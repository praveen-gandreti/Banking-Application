import { Component } from '@angular/core';
import { ServiceService } from '../service.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent {
  hide1=true
  hide2=true
  showSearch=true
  showOtp=false
  user:any
  errorMessage:any
  otp:any
  constructor(private service:ServiceService,private toastar:ToastrService,private router:Router)
  {
    
  }
  form1=new FormGroup({
    userName:new FormControl(null,[Validators.required,Validators.pattern("[a-zA-Z0-9]+@[a-zA-Z]+\.[a-zA-Z]{2,}")])
  })
  form2=new FormGroup(
    {
      id:new FormControl(),
      account:new FormControl(),
      password:new FormControl(),
      role:new FormControl(),
      userName:new FormControl(),
    }
  )
  form3=new FormGroup({
    password:new FormControl(null,Validators.required),
    conformPassword:new FormControl(null,Validators.required)
  })

  form4=new FormGroup({
    formotp:new FormControl(null,Validators.required),
    
  })

  enter()
  {
    if(this.form1.valid)
    {
        this.service.loginWithUserData(this.form1.value.userName).subscribe((d)=>{
          this.showSearch=false
          this.showOtp=true
            this.user=d
            this.otp=(Math.floor(Math.random()*8999)+1000)
            this.service.sendOtp(this.otp,this.form1.value.userName).subscribe((d)=>{
              
            })
            
        },
        (error)=>{
          this.errorMessage=error
          this.toastar.warning(this.errorMessage.error)
        })
    }
    else
    {
      this.toastar.warning("ENTER CORRECT EMAIL")
    }
  }

  conformOtp()
  {
      if(this.form4.valid)
      {
            if(this.form4.value.formotp==this.otp)
            {
                this.showOtp=false
            }
            else
            {
              this.toastar.warning("WRONG OTP")
            }
      }
      else
      {
        this.toastar.warning("ENTER OTP")
      }
  }

  savePassword()
  {
    if(this.form3.valid)
    {
      if(this.form3.value.password==this.form3.value.conformPassword)
      {
        this.form2.setValue({
          id:this.user.id,
          account:this.user.account,
          password:this.form3.value.password,
          role:this.user.role,
          userName:this.user.userName
        })
        this.service.updateUSER(this.form2.value.userName,this.form2.value).subscribe((d)=>{
          this.toastar.success("PASSWORD UPDATED");
          this.router.navigate(["login"])
        },
        (error)=>{
          this.errorMessage=error
          this.toastar.warning(this.errorMessage.error)
        })
      }
      else
      {
        this.toastar.warning("PASSWORD MISS-MATCH")
      }
    }
    else
    {
      this.toastar.warning("ENTER PASSWORDS")
    }
    
  }

  
 

}
