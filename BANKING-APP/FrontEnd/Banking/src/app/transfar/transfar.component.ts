import { Component } from '@angular/core';
import { ServiceService } from '../service.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { TransferSuccessComponent } from '../transfer-success/transfer-success.component';
@Component({
  selector: 'app-transfar',
  templateUrl: './transfar.component.html',
  styleUrls: ['./transfar.component.css']
})
export class TransfarComponent {
  errors:any
  user:any
  constructor(private service:ServiceService,private tostar:ToastrService,private router:Router,private dialog: MatDialog)
  {
      
  }
  form= new FormGroup({
    receiver:new FormControl(null,Validators.required),
    amount:new FormControl(null,Validators.required)
  })

  transfar()
  {
      if(this.form.valid)
      {
        this.service.transfar(sessionStorage.getItem("account"),this.form.value.receiver,this.form.value.amount).subscribe((data)=>{
          const dialogRef = this.dialog.open(TransferSuccessComponent);
            this.tostar.success("TRANSFAR SUCCESSFULL")
        },
        (error)=>{
            this.errors=error
            this.tostar.warning(this.errors.error)
        })
      }
      else
      {
        this.tostar.warning("Please Enter Proper Details")
      }
  }

}
