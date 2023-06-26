import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{
  isLogin=false
  isUser=false;
  isAdmin=false;
  isEmployee=false;
  constructor(private router:Router,private service:ServiceService)
  { 
      if(sessionStorage.length>0)
      {
        this.isLogin=true
      }
  }
  logout()
  {
      sessionStorage.clear()
      this.isLogin=false
      this.isUser=false;
      this.isUser=false;
      this.isAdmin=false
      this.isEmployee=false
      this.router.navigate(["login"])  
  }
  ngOnInit(): void {
      this.service.sub.subscribe((d)=>{
        let role=sessionStorage.getItem("role")
        let user=sessionStorage.getItem("loginId")
        if(user!=null)
        {
          this.isLogin=true
        }
        else
        {
          this.isLogin=false
          
        }
        if(role=="admin")
        {
          this.isAdmin=true
          this.isEmployee=false
          this.isUser=false;
          this.router.navigate(["adminpage"])
        }
        else if(role=="employee")
        {
          this.isEmployee=true
          this.isAdmin=false
          this.isUser=false;
          this.router.navigate(["employee"])
        }
        else if(role=="user")
        {
          this.isUser=true;
          this.isAdmin=false
          this.isEmployee=false
          this.router.navigate(["user"])
        }
        else
        {
          this.isUser=false; 
          this.isAdmin=false
          this.isEmployee=false 
        }
      })
  }


}
