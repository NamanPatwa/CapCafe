import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'

import { AppComponent } from './app.component';
import { AddComponent } from './components/admin components/add/add.component';
import { SearchComponent } from './Components/Admin Components/search/search.component';
import { NaviRoutingModule } from './navi/navi-routing.module';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ListComponent } from './Components/Admin Components/list/list.component';
import { AdminCafedetailsComponent } from './Components/Admin Components/admin-cafedetails/admin-cafedetails.component';
import { UserCafedetailsComponent } from './Components/User Components/user-cafedetails/user-cafedetails.component';
import { UpdateComponent } from './Components/Admin Components/update/update.component';
import { UserListComponent } from './Components/User Components/user-list/user-list.component';
import { ListMenuComponent } from './Components/Admin Components/list-menu/list-menu.component';
import { CafeMenuDetailsListComponent } from './Components/User Components/cafe-menu-details-list/cafe-menu-details-list.component';
import { AdminHomeComponent } from './Components/Admin Components/admin-home/admin-home.component';
import { MenuEditComponent } from './Components/Admin Components/menu-edit/menu-edit.component';
import { MenuListComponent } from './Components/Admin Components/menu-list/menu-list.component';
import { MenuSearchComponent } from './Components/Admin Components/menu-search/menu-search.component';
import { AdminMenuComponent } from './Components/Admin Components/admin-menu/admin-menu.component';
import { UserCartComponent } from './Components/User Components/user-cart/user-cart.component';
import { PlaceOrderComponent } from './Components/User Components/place-order/place-order.component';
import { UserOrderInfoComponent } from './Components/User Components/user-order-info/user-order-info.component';
import { AdminListOrdersComponent } from './Components/Admin Components/admin-list-orders/admin-list-orders.component';
import { AdminViewOrderdetailsComponent } from './Components/Admin Components/admin-view-orderdetails/admin-view-orderdetails.component';
import { HelpdeskAdminComponent } from './Components/Admin Components/helpdesk-admin/helpdesk-admin.component';
import { AdminChatComponent } from './Components/Admin Components/admin-chat/admin-chat.component';
import { HelpdeskUserComponent } from './Components/User Components/helpdesk-user/helpdesk-user.component';
import { UserChatComponent } from './Components/User Components/user-chat/user-chat.component';
import { SignupComponent } from './Components/Shared Components/signup/signup.component';
import { LoginComponent } from './Components/Shared Components/login/login.component';
import { ForgotPasswordComponent } from './Components/User Components/forgot-password/forgot-password.component';
import { GetAllComponent } from './Components/Admin Components/get-all/get-all.component';
import { ResetPasswordComponent } from './Components/User Components/reset-password/reset-password.component';
import { ProfileComponent } from './Components/User Components/profile/profile.component';
import { AddCafeFeedbackComponent } from './Components/User Components/add-cafe-feedback/add-cafe-feedback.component';
import { AddItemFeedbackComponent } from './Components/User Components/add-item-feedback/add-item-feedback.component';
import { ViewCafeFeedbackComponent } from './Components/User Components/view-cafe-feedback/view-cafe-feedback.component';
import { ViewItemFeedbackComponent } from './Components/User Components/view-item-feedback/view-item-feedback.component';
import { UserOrdersListComponent } from './Components/User Components/user-orders-list/user-orders-list.component';
import { UserOrderSummaryComponent } from './Components/User Components/user-order-summary/user-order-summary.component';
import { AdminMenuListComponent } from './Components/Admin Components/admin-menu-list/admin-menu-list.component';
import { AuthGuardService } from './Guards/auth-guard.service';
import { DeactivateGuardService } from './Guards/deactivate-guard.service';
import { RoleGuardService } from './Guards/role-guard.service';
import { HttpErrorInterceptor } from './http-interceptor';

@NgModule({
  declarations: [
    AppComponent,
    AddComponent,
    SearchComponent,
    ListComponent,
    AdminCafedetailsComponent,
    UserCafedetailsComponent,
    UpdateComponent,
    UserListComponent,
    ListMenuComponent,
    CafeMenuDetailsListComponent,
    AdminHomeComponent,
    MenuEditComponent,
    MenuListComponent,
    MenuSearchComponent,
    AdminMenuComponent,
    UserCartComponent,
    PlaceOrderComponent,
    UserOrderInfoComponent,
    AdminListOrdersComponent,
    AdminViewOrderdetailsComponent,
    HelpdeskAdminComponent,
    AdminChatComponent,
    HelpdeskUserComponent,
    UserChatComponent,
    SignupComponent,
    LoginComponent,
    ForgotPasswordComponent,
    GetAllComponent,
    ResetPasswordComponent,
    ProfileComponent,
    AddCafeFeedbackComponent,
    AddItemFeedbackComponent,
    ViewCafeFeedbackComponent,
    ViewItemFeedbackComponent,
    UserOrdersListComponent,
    UserOrderSummaryComponent,
    AdminMenuListComponent
  ],
  imports: [
    BrowserModule, NaviRoutingModule, FormsModule, HttpClientModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: HttpErrorInterceptor,
    multi: true
  },
    AuthGuardService, DeactivateGuardService, RoleGuardService],
  bootstrap: [AppComponent]
})
export class AppModule { }
