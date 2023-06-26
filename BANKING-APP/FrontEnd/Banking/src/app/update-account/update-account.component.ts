import { Component } from '@angular/core';
import { ServiceService } from '../service.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-update-account',
  templateUrl: './update-account.component.html',
  styleUrls: ['./update-account.component.css']
})
export class UpdateAccountComponent {

  userAccount:any
  errorMessage:any
  showSearch=true
  constructor(private service:ServiceService,private tostar:ToastrService,private router:Router)
  {
      
  }
  form1=new FormGroup({
    account:new FormControl(null,Validators.required)
  })
  getAccount()
  {
    if(this.form1.valid)
    {
        this.service.getAccount(this.form1.value.account).subscribe((d)=>{
            this.userAccount=d;
            this.showSearch=false
            this.form2.setValue({
              account:this.userAccount.account,
              firstName:this.userAccount.firstName,
              lastName:this.userAccount.lastName,
              balance:this.userAccount.balance,
              address:this.userAccount.address,
              phone:this.userAccount.phone,
              pan:this.userAccount.pan,
              email:this.userAccount.email,
              online:this.userAccount.online,
              aadhar:this.userAccount.aadhar
            })
        },
        (error)=>{
          this.errorMessage=error;
          this.tostar.warning(this.errorMessage.error)
        })
    }
  }
  updateAccount()
  {
    this.service.updateUserAccount(this.form2.value.account,this.form2.value).subscribe((da)=>{
        this.userAccount=da
        this.form2.setValue({
        account:this.userAccount.account,
        firstName:this.userAccount.firstName,
        lastName:this.userAccount.lastName,
        balance:this.userAccount.balance,
        address:this.userAccount.address,
        phone:this.userAccount.phone,
        pan:this.userAccount.pan,
        email:this.userAccount.email,
        online:this.userAccount.online,
        aadhar:this.userAccount.aadhar
      })
      this.tostar.success("SUCCESSFULLY UPDATED")
      },
      (error)=>{
        this.errorMessage=error
        this.tostar.warning(this.errorMessage.error)
      })
  }
  form2=new FormGroup({
    account:new FormControl(null,Validators.required),
    firstName:new FormControl(null,Validators.required),
    lastName:new FormControl(null,Validators.required),
    balance:new FormControl(null),
    address:new FormControl(null,Validators.required),
    phone:new FormControl(null,Validators.required),
    pan:new FormControl(null),
    email:new FormControl(null,Validators.required),
    online:new FormControl(true),
    aadhar:new FormControl(null)
  })
}
