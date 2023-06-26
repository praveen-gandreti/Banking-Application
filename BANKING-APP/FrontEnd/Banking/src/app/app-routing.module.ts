import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { EmployeeComponent } from './employee/employee.component';
import { AdminComponent } from './admin/admin.component';
import { AuthGuard } from './auth.guard';
import { UserComponent } from './user/user.component';
import { DipositComponent } from './diposit/diposit.component';
import { WithdrawComponent } from './withdraw/withdraw.component';
import { BalanceCheckComponent } from './balance-check/balance-check.component';
import { TransfarComponent } from './transfar/transfar.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { TransferSuccessComponent } from './transfer-success/transfer-success.component';
import { UpdateAccountComponent } from './update-account/update-account.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { AdminPageComponent } from './admin-page/admin-page.component';

const routes: Routes = [
  {
    path:"login",component:LoginComponent
  },
  {
    path:"registration",component:RegistrationComponent
  },
  {
    path:"employee",component:EmployeeComponent,canActivate:[AuthGuard]
  },
  {
    path:"admin",component:AdminComponent,canActivate:[AuthGuard]
  },
  {
    path:"adminpage",component:AdminPageComponent,canActivate:[AuthGuard]
  },
  {
    path:"user",component:UserComponent,canActivate:[AuthGuard]
  },
  {
    path:"diposit",component:DipositComponent,canActivate:[AuthGuard]
  },
  {
    path:"withdraw",component:WithdrawComponent,canActivate:[AuthGuard]
  },
  {
    path:"balance",component:BalanceCheckComponent,canActivate:[AuthGuard]
  },
  {
    path:"transfar",component:TransfarComponent,canActivate:[AuthGuard]
  },
  {
    path:"notfound",component:NotFoundComponent
  },
  {
    path:"message",component:TransferSuccessComponent
  },
  {
    path:"update/account",component:UpdateAccountComponent,canActivate:[AuthGuard]
  },
  {
    path:"login/forgot",component:ForgotPasswordComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
