import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './component/home-page/home-page.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from '@angular/material/button';
import { LoginPageComponent } from './component/login-page/login-page.component';
import { SignupPageComponent } from './component/signup-page/signup-page.component';
import {MatFormFieldModule} from "@angular/material/form-field";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {SignupService} from "./component/services/signup.service";
import {HttpClientModule} from "@angular/common/http";
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatChipsModule} from '@angular/material/chips';
import {MatAutocompleteModule} from "@angular/material/autocomplete";
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { authInterceptorProviders} from "./component/services/auth.interceptor";
import { ListUserComponent } from './component/user/list-user/list-user.component';
import { UpdateUserComponent } from './component/user/update-user/update-user.component';
import {MatTableModule} from "@angular/material/table";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatCardModule} from "@angular/material/card";
import {MatSelectModule} from "@angular/material/select";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatStepperModule} from "@angular/material/stepper";
import { MatInputModule } from '@angular/material/input';
import {ChartInService} from "./component/services/chart-in.service";
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { SearchPipePipe } from './search-pipe.pipe';
import { NgxMaskModule, IConfig } from 'ngx-mask'
@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    LoginPageComponent,
    SignupPageComponent,
    DashboardComponent,
    ListUserComponent,
    UpdateUserComponent,
    SearchPipePipe,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule
    , MatToolbarModule, BrowserAnimationsModule, MatIconModule, MatButtonModule,
    MatFormFieldModule, ReactiveFormsModule,
    FormsModule
    , HttpClientModule,
    MatInputModule,MatSnackBarModule,
    MatChipsModule, MatAutocompleteModule,
    MatTableModule, MatPaginatorModule, MatCardModule, MatSelectModule, MatDatepickerModule,
    MatStepperModule,Ng2SearchPipeModule,NgxMaskModule.forRoot()
  ],
  providers: [SignupService, authInterceptorProviders,ChartInService],
  bootstrap: [AppComponent]
})
export class AppModule { }
