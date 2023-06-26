import { Component } from '@angular/core';
import { ServiceService } from '../service.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent {
  data:any
  errorMessage:any
  constructor(private service:ServiceService,private tostar:ToastrService)
  {
    this.service.getAllRegistrations().subscribe((d)=>{
      this.data=d
    },
    (error)=>{
    })
  }
  createAccount(id:any)
  {
      this.service.createAccount(id).subscribe((d)=>{
        this.tostar.success("CREATED SUCCESSFULLY")
        this.service.getAllRegistrations().subscribe((d)=>{
        this.data=d
        })
      },
      (error)=>{
        this.errorMessage=error
        this.tostar.warning(this.errorMessage.error)
      })
  }



  deleteAccount(id:any)
  {
      this.service.deleteRegistration(id).subscribe((d)=>{
        this.service.getAllRegistrations().subscribe((d)=>{
          this.data=d
          this.tostar.success("DELETED SUCCESSFULLY")
        },
        (error)=>{
          this.errorMessage=error
          this.tostar.warning(this.errorMessage.error)
        })
      },
      (error)=>{
        this.errorMessage=error
        this.tostar.warning(this.errorMessage.error)
      })
  }
}
