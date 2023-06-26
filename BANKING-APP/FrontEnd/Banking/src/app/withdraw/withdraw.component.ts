import { Component } from '@angular/core';
import { ServiceService } from '../service.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';
@Component({
  selector: 'app-withdraw',
  templateUrl: './withdraw.component.html',
  styleUrls: ['./withdraw.component.css']
})
export class WithdrawComponent {
  errormessage:any
  constructor(private service:ServiceService,private tostar:ToastrService,private router:Router)
  {

  }
  form=new FormGroup({
    account:new FormControl(null,Validators.required),
    amount:new FormControl(null,Validators.required)
  })

  // CALLING SERVICE TO DEPOSIT AMOUNT
  withdraw()
  {
      if(this.form.valid)
      {
          this.service.withdraw(this.form.value.account,this.form.value.amount).subscribe((data)=>{
              this.tostar.success("WITHDRAW SUCCESSFULLY")
              this.form.reset()
          },
          (error)=>{
              this.errormessage=error
              this.tostar.warning(this.errormessage.error)
              this.form.reset()
          })
      }
      else
      {
        this.tostar.warning("Please Enter Data")
      }
  }

}
