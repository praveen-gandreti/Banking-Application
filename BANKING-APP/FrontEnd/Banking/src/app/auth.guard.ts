import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private router:Router,private toaster:ToastrService)
  {

  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    let path=route.url[0].path
    console.log(path)
    if(path=="employee")
    {
      if(sessionStorage.getItem("role")=="employee")
      {
          return true;
      }
      else
      {
          this.toaster.warning("You Don't Have Access")
          this.router.navigate(["login"])
          return false;
      }
    }
    else if(path=="admin")
    {
      if(sessionStorage.getItem("role")=="admin")
      {
        return true;
      }
      else
      {
          this.toaster.warning("You Don't Have Access")
          this.router.navigate(["login"])
          return false;
      }
    }
    else if(path=="adminpage")
    {
      if(sessionStorage.getItem("role")=="admin")
      {
        return true;
      }
      else
      {
        this.router.navigate(["adminpage"])
          this.toaster.warning("You Don't Have Access")
          this.router.navigate(["login"])
          return false;
      }
    }
    else if(path=="user")
    {
        if(sessionStorage.getItem("role")=="user")
        {
          return true;
        }
        else
        {
            this.toaster.warning("You Don't Have Access")
            this.router.navigate(["login"])
            return false;
        }
    }
    else if(path=="diposit")
    {
      if(sessionStorage.getItem("role")=="employee")
      {
        return true;
      }
      else
      {
          this.toaster.warning("You Don't Have Access")
          this.router.navigate(["login"])
          return false;
      }
    }
    else if(path=="withdraw")
    {
      if(sessionStorage.getItem("role")=="employee")
      {
        return true;
      }
      else
      {
          this.toaster.warning("You Don't Have Access")
          this.router.navigate(["login"])
          return false;
      }
    }
    else if(path=="balance")
    {
      if(sessionStorage.getItem("role")=="user" || sessionStorage.getItem("role")=="employee")
      {
        
        return true;
      }
      else
      {
          this.toaster.warning("You Don't Have Access")
          this.router.navigate(["login"])
          return false;
      }
    }
    else if(path=="transfar")
    {
      if(sessionStorage.getItem("role")=="user")
      {
        return true;
      }
      else
      {
          this.toaster.warning("You Don't Have Access")
          this.router.navigate(["login"])
          return false;
      }
    }
    else if(path=="update")
    {
      if(sessionStorage.getItem("role")=="employee" || sessionStorage.getItem("role")=="admin")
      {
        
        return true;
      }
      else
      {
          this.toaster.warning("You Don't Have Access")
          this.router.navigate(["login"])
          return false;
      }
    }
    else
    return true
  }
  
}
