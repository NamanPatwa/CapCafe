import { Injectable } from '@angular/core';
import { CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { CafedetailsService } from '../cafedetails/cafedetails.service';

@Injectable({
  providedIn: 'root'
})
export class DeactivateGuardService implements CanActivate{

  constructor(private service:CafedetailsService,private deactiveStateRouter:Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    if(this.service.role()=="ADMIN"||this.service.role()=="USER"){
      if(this.service.role()=="USER"){
        this.deactiveStateRouter.navigate(['user']);
        return false;
      }
      if(this.service.role()=="ADMIN"){
        this.deactiveStateRouter.navigate(['admin']);
        return false;
      }  
    }
    return true;
  }
}
