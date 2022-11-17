import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginPageComponent} from "./component/login-page/login-page.component";
import {SignupPageComponent} from "./component/signup-page/signup-page.component";
import {HomePageComponent} from "./component/home-page/home-page.component";
import {DashboardComponent} from "./component/dashboard/dashboard.component";
import {AuthGuard} from "./component/services/auth.guard";
import {ListUserComponent} from "./component/user/list-user/list-user.component";
import {UpdateUserComponent} from "./component/user/update-user/update-user.component";
const routes: Routes = [
  {
    path:"login",
    component:LoginPageComponent,
    pathMatch:"full"
  },
  {
    path:"signup",
    component:SignupPageComponent,
    pathMatch:"full"
  },

  {
    path:"",
    component:HomePageComponent,
    pathMatch:"full"
  }
  ,{
  path:"dashboard",
    component:DashboardComponent,
    pathMatch:"full",
    canActivate:[AuthGuard]
  },
  {
    path:"dashboard/getUsers",
    component:ListUserComponent,
    pathMatch:"full",
    canActivate:[AuthGuard]

  }
  ,
  {
    path:"dashboard/:id",
    component:UpdateUserComponent,
    canActivate:[AuthGuard]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
