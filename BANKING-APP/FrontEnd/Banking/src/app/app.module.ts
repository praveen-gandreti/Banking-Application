import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { RegistrationComponent } from './registration/registration.component';
import { LoginComponent } from './login/login.component';
import { RouterModule } from '@angular/router';
import {MatToolbarModule} from '@angular/material/toolbar';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HomeComponent } from './home/home.component'; 
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card'; 
import {MatInputModule} from '@angular/material/input'; 
import {MatCheckboxModule} from '@angular/material/checkbox';
import { ServiceService } from './service.service';
import { ReactiveFormsModule } from '@angular/forms'; 
import { HttpClientModule } from '@angular/common/http';
import { EmployeeComponent } from './employee/employee.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component'; 
import {MatFormFieldModule} from '@angular/material/form-field'; 
import {MatIconModule} from '@angular/material/icon';
import { DipositComponent } from './diposit/diposit.component';
import { WithdrawComponent } from './withdraw/withdraw.component';
import { BalanceCheckComponent } from './balance-check/balance-check.component';
import { TransfarComponent } from './transfar/transfar.component';
import { NotFoundComponent } from './not-found/not-found.component'; 
import {MatDialogModule} from '@angular/material/dialog';
import { TransferSuccessComponent } from './transfer-success/transfer-success.component'; 
import {MatTableModule} from '@angular/material/table';
import { UpdateAccountComponent } from './update-account/update-account.component';
import { DeleteAccountComponent } from './delete-account/delete-account.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { AdminPageComponent } from './admin-page/admin-page.component'; 
@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    LoginComponent,
    HomeComponent,
    EmployeeComponent,
    AdminComponent,
    UserComponent,
    DipositComponent,
    WithdrawComponent,
    BalanceCheckComponent,
    TransfarComponent,
    NotFoundComponent,
    TransferSuccessComponent,
    UpdateAccountComponent,
    DeleteAccountComponent,
    ForgotPasswordComponent,
    AdminPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    RouterModule,
    MatToolbarModule,
    NgbModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatFormFieldModule,
    MatIconModule,
    MatDialogModule,
    MatTableModule,
    MatCheckboxModule
  ],
  providers: [ServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
