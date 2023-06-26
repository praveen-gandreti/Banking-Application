import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }

  sub=new Subject();

  noticeAll()
  {
    this.sub.next('');
  }

  // REGISTRATION - CREATING NEW USER REGISTRATION
  newAccountRegistration(data:any)
  {
    console.log(data)
    return this.http.post("http://localhost:8080/registration/save",data);
  }

  // LOGIN - VALIDATING USER DATA 
  loginWithUserData(data:any)
  {
    return this.http.get("http://localhost:9090/user/"+data)
  }

  // FETCHING BALANCE FROM ACCOUNT
  getAccount(account:any)
  {
    return this.http.get("http://localhost:9090/balance/check/"+account)
  }

  // TRANSFAR AMOUNT FROM SOURCE TO DESTINATION
  transfar(send:any,receiver:any,amount:any)
  {
    return this.http.get("http://localhost:9090/transfar/"+send+"/"+receiver+"?amount="+amount)
  }

  // DIPOSIT AMOUNT
  diposit(account:any,amount:any)
  {
    return this.http.get("http://localhost:9090/diposit/user/"+account+"?amount="+amount)
  }

  // WITHDRAW AMOUNT
  withdraw(account:any,amount:any)
  {
    return this.http.get("http://localhost:9090/withdraw/user/"+account+"?amount="+amount)
  }

  // GET ALL USERS REGISTRATION DETAILS FOR ADMIN TO CREATE ACCOUNT
  getAllRegistrations()
  {
    return this.http.get("http://localhost:8080/registration/users/all");
  }

  // CREATE ACCOUNT WITH REGISTRATION DETAILS
  createAccount(id:any)
  {
    return this.http.get("http://localhost:8080/create/account/"+id);
  }

  // DELETING REGISTRATION DETAILS
  deleteRegistration(id:any)
  {
    return this.http.get("http://localhost:8080/delete/account/"+id);
  }

  // UPDATING USER ACCOUNT DETAILS
  updateUserAccount(account:any,user:any)
  {
    console.log(account+"-------")
    console.log(user)
    return this.http.put("http://localhost:9090/update/account/"+account,user)
  }

  // UPDATING USER DATA
  updateUSER(account:any,user:any)
  {
    console.log(account+"*---")
    console.log(user)
    return this.http.put("http://localhost:9090/update/user/"+account,user)
  }

  // SENDING OTP TO EMAIL
  sendOtp(otp:any,userName:any)
  {
    return this.http.get("http://localhost:9090/send?otp="+otp+"&username="+userName)
  }
}
