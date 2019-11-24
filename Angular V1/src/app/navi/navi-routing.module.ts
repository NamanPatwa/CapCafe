import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SearchComponent } from '../search/search.component';
import { AddComponent } from '../add/add.component';
import { ListComponent } from '../list/list.component';
import { AdminCafedetailsComponent } from '../admin-cafedetails/admin-cafedetails.component';
import { UserCafedetailsComponent } from '../user-cafedetails/user-cafedetails.component';
import { UpdateComponent } from '../update/update.component';
import { UserListComponent } from '../user-list/user-list.component';
import { ListMenuComponent } from '../list-menu/list-menu.component';
import { CafeMenuDetailsListComponent } from '../cafe-menu-details-list/cafe-menu-details-list.component';
import { AdminHomeComponent } from '../admin-home/admin-home.component';
import { MenuEditComponent } from '../menu-edit/menu-edit.component';
import { MenuListComponent } from '../menu-list/menu-list.component';
import { MenuSearchComponent } from '../menu-search/menu-search.component';
import { AdminMenuComponent } from '../admin-menu/admin-menu.component';
import { UserCartComponent } from '../user-cart/user-cart.component';
import { PlaceOrderComponent } from '../place-order/place-order.component';
import { UserOrderInfoComponent } from '../user-order-info/user-order-info.component';
import { AdminListOrdersComponent } from '../admin-list-orders/admin-list-orders.component';
import { AdminViewOrderdetailsComponent } from '../admin-view-orderdetails/admin-view-orderdetails.component';
import { HelpdeskAdminComponent } from '../helpdesk-admin/helpdesk-admin.component';
import { AdminChatComponent } from '../admin-chat/admin-chat.component';
import { HelpdeskUserComponent } from '../helpdesk-user/helpdesk-user.component';
import { UserChatComponent } from '../user-chat/user-chat.component';
import { SignupComponent } from '../signup/signup.component';
import { LoginComponent } from '../login/login.component';
import { ForgotPasswordComponent } from '../forgot-password/forgot-password.component';
import { GetAllComponent } from '../get-all/get-all.component';
import { ResetPasswordComponent } from '../reset-password/reset-password.component';
import { ProfileComponent } from '../profile/profile.component';
import { AddCafeFeedbackComponent } from '../add-cafe-feedback/add-cafe-feedback.component';
import { AddItemFeedbackComponent } from '../add-item-feedback/add-item-feedback.component';
import { ViewCafeFeedbackComponent } from '../view-cafe-feedback/view-cafe-feedback.component';
import { ViewItemFeedbackComponent } from '../view-item-feedback/view-item-feedback.component';
import { UserOrdersListComponent } from '../user-orders-list/user-orders-list.component';
import { UserOrderSummaryComponent } from '../user-order-summary/user-order-summary.component';
import { AdminMenuListComponent } from '../admin-menu-list/admin-menu-list.component';
import { DeactivateGuardService } from '../Guards/deactivate-guard.service';
import { RoleGuardService } from '../Guards/role-guard.service';
import { AuthGuardService } from '../Guards/auth-guard.service';

const routes: Routes = [
  {path:'',redirectTo:'/login',pathMatch:'full'},
  {path:'admin-cafedetails',component:AdminCafedetailsComponent},
  {path:'user-cafedetails',component:UserCafedetailsComponent},
  {path:'user-list',component:UserListComponent},
  {path:'list-menu',component:ListMenuComponent},
  {path:'search',component:SearchComponent},
  {path:'add',component:AddComponent},
  {path:'list',component:ListComponent},
  {path:'update',component:UpdateComponent},
  {path:'cafe-menu',component:CafeMenuDetailsListComponent},
  {path:'admin-home',component:AdminHomeComponent },
  {path:'menu-edit',component:MenuEditComponent },
  {path:'menu-list',component:MenuListComponent },
  {path:'menu-search',component:MenuSearchComponent},
  {path:'admin-menu',component:AdminMenuComponent },
  {path:'user-cart',component:UserCartComponent },
  {path:'place-order', component:PlaceOrderComponent},
  {path:'user-order-details', component:UserOrderInfoComponent},
  {path:'admin-list-orders', component:AdminListOrdersComponent},
  {path:'admin-view-orderdetails/:id', component:AdminViewOrderdetailsComponent},
  {path:'admin-helpdesk', component:HelpdeskAdminComponent},
  {path:'admin-chat/:id', component:AdminChatComponent},
  {path:'user-helpdesk', component:HelpdeskUserComponent},
  {path:'user-chat/:id', component:UserChatComponent},
  {path:'signup', component:SignupComponent},
  {path:'login', component:LoginComponent, canActivate:[DeactivateGuardService]},
  {path:"forgotpassword",component:ForgotPasswordComponent},
  {path:"getall",component:GetAllComponent, canActivate:[RoleGuardService]},
  {path:"resetpassword",component:ResetPasswordComponent, canActivate:[AuthGuardService]},
  {path:"profile",component:ProfileComponent},
  {path:"add-cafe-feedback",component:AddCafeFeedbackComponent},
  {path:"add-item-feedback",component:AddItemFeedbackComponent},
  {path:"view-feedback",component:ViewCafeFeedbackComponent},
  {path:"view-item-feedback",component:ViewItemFeedbackComponent},
  {path:"your-orders",component:UserOrdersListComponent},
  {path:"user-order-summary",component:UserOrderSummaryComponent},
  {path:"admin-menu-list",component:AdminMenuListComponent},
  {path:'**',redirectTo:'/login',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class NaviRoutingModule { }
