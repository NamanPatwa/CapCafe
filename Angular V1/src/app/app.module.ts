import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'

import { AppComponent } from './app.component';
import { AddComponent } from './add/add.component';
import { SearchComponent } from './search/search.component';
import { NaviRoutingModule } from './navi/navi-routing.module';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ListComponent } from './list/list.component';
import { AdminCafedetailsComponent } from './admin-cafedetails/admin-cafedetails.component';
import { UserCafedetailsComponent } from './user-cafedetails/user-cafedetails.component';
import { UpdateComponent } from './update/update.component';
import { UserListComponent } from './user-list/user-list.component';
import { ListMenuComponent } from './list-menu/list-menu.component';
import { CafeMenuDetailsListComponent } from './cafe-menu-details-list/cafe-menu-details-list.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { MenuEditComponent } from './menu-edit/menu-edit.component';
import { MenuListComponent } from './menu-list/menu-list.component';
import { MenuSearchComponent } from './menu-search/menu-search.component';
import { AdminMenuComponent } from './admin-menu/admin-menu.component';
import { UserCartComponent } from './user-cart/user-cart.component';
import { PlaceOrderComponent } from './place-order/place-order.component';
import { UserOrderInfoComponent } from './user-order-info/user-order-info.component';
import { AdminListOrdersComponent } from './admin-list-orders/admin-list-orders.component';
import { AdminViewOrderdetailsComponent } from './admin-view-orderdetails/admin-view-orderdetails.component';
import { HelpdeskAdminComponent } from './helpdesk-admin/helpdesk-admin.component';
import { AdminChatComponent } from './admin-chat/admin-chat.component';
import { HelpdeskUserComponent } from './helpdesk-user/helpdesk-user.component';
import { UserChatComponent } from './user-chat/user-chat.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { GetAllComponent } from './get-all/get-all.component';
import { ResetPasswordComponent } from './reset-password/reset-password.component';
import { ProfileComponent } from './profile/profile.component';
import { AddCafeFeedbackComponent } from './add-cafe-feedback/add-cafe-feedback.component';
import { AddItemFeedbackComponent } from './add-item-feedback/add-item-feedback.component';
import { ViewCafeFeedbackComponent } from './view-cafe-feedback/view-cafe-feedback.component';
import { ViewItemFeedbackComponent } from './view-item-feedback/view-item-feedback.component';
import { UserOrdersListComponent } from './user-orders-list/user-orders-list.component';
import { UserOrderSummaryComponent } from './user-order-summary/user-order-summary.component';
import { AdminMenuListComponent } from './admin-menu-list/admin-menu-list.component';
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
  AuthGuardService,DeactivateGuardService,RoleGuardService],
  bootstrap: [AppComponent]
})
export class AppModule { }
