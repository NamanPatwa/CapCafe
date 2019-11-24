import { Injectable } from '@angular/core';
import { CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { CafedetailsService } from '../cafedetails/cafedetails.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate{

  constructor(private service:CafedetailsService, private route:Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    if(this.service.role()=="ADMIN"||this.service.role()=="USER"){
      return true;
    }

    this.route.navigate(['login']);
    return false;
  }
}
