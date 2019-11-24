import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SearchComponent } from '../Components/Admin Components/search/search.component';
import { AddComponent } from '../components/admin components/add/add.component';
import { ListComponent } from '../Components/Admin Components/list/list.component';
import { AdminCafedetailsComponent } from '../Components/Admin Components/admin-cafedetails/admin-cafedetails.component';
import { UserCafedetailsComponent } from '../Components/User Components/user-cafedetails/user-cafedetails.component';
import { UpdateComponent } from '../Components/Admin Components/update/update.component';
import { UserListComponent } from '../Components/User Components/user-list/user-list.component';
import { ListMenuComponent } from '../Components/Admin Components/list-menu/list-menu.component';
import { CafeMenuDetailsListComponent } from '../Components/User Components/cafe-menu-details-list/cafe-menu-details-list.component';
import { AdminHomeComponent } from '../Components/Admin Components/admin-home/admin-home.component';
import { MenuEditComponent } from '../Components/Admin Components/menu-edit/menu-edit.component';
import { MenuListComponent } from '../Components/Admin Components/menu-list/menu-list.component';
import { MenuSearchComponent } from '../Components/Admin Components/menu-search/menu-search.component';
import { AdminMenuComponent } from '../Components/Admin Components/admin-menu/admin-menu.component';
import { UserCartComponent } from '../Components/User Components/user-cart/user-cart.component';
import { PlaceOrderComponent } from '../Components/User Components/place-order/place-order.component';
import { UserOrderInfoComponent } from '../Components/User Components/user-order-info/user-order-info.component';
import { AdminListOrdersComponent } from '../Components/Admin Components/admin-list-orders/admin-list-orders.component';
import { AdminViewOrderdetailsComponent } from '../Components/Admin Components/admin-view-orderdetails/admin-view-orderdetails.component';
import { HelpdeskAdminComponent } from '../Components/Admin Components/helpdesk-admin/helpdesk-admin.component';
import { AdminChatComponent } from '../Components/Admin Components/admin-chat/admin-chat.component';
import { HelpdeskUserComponent } from '../Components/User Components/helpdesk-user/helpdesk-user.component';
import { UserChatComponent } from '../Components/User Components/user-chat/user-chat.component';
import { SignupComponent } from '../Components/Shared Components/signup/signup.component';
import { LoginComponent } from '../Components/Shared Components/login/login.component';
import { ForgotPasswordComponent } from '../Components/User Components/forgot-password/forgot-password.component';
import { GetAllComponent } from '../Components/Admin Components/get-all/get-all.component';
import { ResetPasswordComponent } from '../Components/User Components/reset-password/reset-password.component';
import { ProfileComponent } from '../Components/User Components/profile/profile.component';
import { AddCafeFeedbackComponent } from '../Components/User Components/add-cafe-feedback/add-cafe-feedback.component';
import { AddItemFeedbackComponent } from '../Components/User Components/add-item-feedback/add-item-feedback.component';
import { ViewCafeFeedbackComponent } from '../Components/User Components/view-cafe-feedback/view-cafe-feedback.component';
import { ViewItemFeedbackComponent } from '../Components/User Components/view-item-feedback/view-item-feedback.component';
import { UserOrdersListComponent } from '../Components/User Components/user-orders-list/user-orders-list.component';
import { UserOrderSummaryComponent } from '../Components/User Components/user-order-summary/user-order-summary.component';
import { AdminMenuListComponent } from '../Components/Admin Components/admin-menu-list/admin-menu-list.component';
import { DeactivateGuardService } from '../Guards/deactivate-guard.service';
import { RoleGuardService } from '../Guards/role-guard.service';
import { AuthGuardService } from '../Guards/auth-guard.service';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'admin-cafedetails', component: AdminCafedetailsComponent, canActivate: [RoleGuardService]},
  { path: 'user-cafedetails', component: UserCafedetailsComponent, canActivate:[AuthGuardService]   },
  { path: 'user-list', component: UserListComponent, canActivate:[AuthGuardService]  },
  { path: 'list-menu', component: ListMenuComponent, canActivate: [RoleGuardService] },
  { path: 'search', component: SearchComponent, canActivate: [RoleGuardService] },
  { path: 'add', component: AddComponent, canActivate: [RoleGuardService]},
  { path: 'list', component: ListComponent, canActivate: [RoleGuardService] },
  { path: 'update', component: UpdateComponent, canActivate: [RoleGuardService] },
  { path: 'cafe-menu', component: CafeMenuDetailsListComponent, canActivate:[AuthGuardService]  },
  { path: 'admin-home', component: AdminHomeComponent, canActivate: [RoleGuardService] },
  { path: 'menu-edit', component: MenuEditComponent, canActivate: [RoleGuardService] },
  { path: 'menu-list', component: MenuListComponent, canActivate: [RoleGuardService] },
  { path: 'menu-search', component: MenuSearchComponent, canActivate: [RoleGuardService] },
  { path: 'admin-menu', component: AdminMenuComponent, canActivate: [RoleGuardService]  },
  { path: 'user-cart', component: UserCartComponent, canActivate:[AuthGuardService] },
  { path: 'place-order', component: PlaceOrderComponent, canActivate:[AuthGuardService] },
  { path: 'user-order-details', component: UserOrderInfoComponent, canActivate:[AuthGuardService] },
  { path: 'admin-list-orders', component: AdminListOrdersComponent, canActivate: [RoleGuardService]},
  { path: 'admin-view-orderdetails/:id', component: AdminViewOrderdetailsComponent, canActivate: [RoleGuardService] },
  { path: 'admin-helpdesk', component: HelpdeskAdminComponent, canActivate: [RoleGuardService] },
  { path: 'admin-chat/:id', component: AdminChatComponent, canActivate: [RoleGuardService] },
  { path: 'user-helpdesk', component: HelpdeskUserComponent, canActivate:[AuthGuardService]},
  { path: 'user-chat/:id', component: UserChatComponent, canActivate:[AuthGuardService] },
  { path: 'signup', component: SignupComponent, canActivate: [DeactivateGuardService] },
  { path: 'login', component: LoginComponent, canActivate: [DeactivateGuardService] },
  { path: "forgotpassword", component: ForgotPasswordComponent, canActivate: [DeactivateGuardService] },
  { path: "getall", component: GetAllComponent, canActivate: [RoleGuardService] },
  { path: "resetpassword", component: ResetPasswordComponent, canActivate:[AuthGuardService] },
  { path: "profile", component: ProfileComponent, canActivate:[AuthGuardService] },
  { path: "add-cafe-feedback", component: AddCafeFeedbackComponent, canActivate:[AuthGuardService] },
  { path: "add-item-feedback", component: AddItemFeedbackComponent, canActivate:[AuthGuardService] },
  { path: "view-feedback", component: ViewCafeFeedbackComponent, canActivate:[AuthGuardService] },
  { path: "view-item-feedback", component: ViewItemFeedbackComponent, canActivate:[AuthGuardService] },
  { path: "your-orders", component: UserOrdersListComponent, canActivate:[AuthGuardService] },
  { path: "user-order-summary", component: UserOrderSummaryComponent, canActivate:[AuthGuardService]},
  { path: "admin-menu-list", component: AdminMenuListComponent, canActivate: [RoleGuardService]},
  { path: '**', redirectTo: '/login', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class NaviRoutingModule { }
