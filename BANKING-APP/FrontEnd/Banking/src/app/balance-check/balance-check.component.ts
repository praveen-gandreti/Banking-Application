import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../service.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-balance-check',
  templateUrl: './balance-check.component.html',
  styleUrls: ['./balance-check.component.css']
})
export class BalanceCheckComponent implements OnInit{

  showSearch=true
  account:any={
    "firstName":"",
    "lastName":"",
    "balance":0
  }
  constructor(private service:ServiceService,private tostar:ToastrService,private router:Router)
  {
      if(sessionStorage.length>0)
      {
          if(sessionStorage.getItem("role")=="user" || sessionStorage.getItem("role")=="")
          {
            this.showSearch=false
          }
          let currentUser:any
          this.service.loginWithUserData(sessionStorage.getItem("loginId")).subscribe((user)=>{
            currentUser=user
            this.service.getAccount(currentUser.account).subscribe((data)=>{
                this.account=data
                this.form1.setValue({
                  firstName:this.account.firstName,
                  lastName:this.account.lastName,
                  balance:this.account.balance
                })
            })
          })
      }
  }
  form1=new FormGroup({
    firstName:new FormControl(this.account.firstName),
    lastName:new FormControl(this.account.lastName),
    balance:new FormControl(this.account.balance)
  })
  form2=new FormGroup({
    account:new FormControl(null,Validators.required)
  })

  // GETTING ACCOUNT DETAILS BY ROLE EMPLOYEE
  balance()
  {
    
    if(this.form2.valid)
    {
       this.showSearch=false;
        this.service.getAccount(this.form2.value.account).subscribe((ac)=>{
            this.account=ac
            this.form1.setValue({
              firstName:this.account.firstName,
              lastName:this.account.lastName,
              balance:this.account.balance
            })
        },
        (error)=>{
            this.router.navigate(["notfound"])
        })
    }
    else
    {
      this.tostar.warning("Please Enter Account Number")
    }
  }
  ngOnInit(): void {
      
  }
  

}
