import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Router, RouterStateSnapshot } from '@angular/router';
import { CafedetailsService } from '../Services/cafedetails/cafedetails.service';

@Injectable({
  providedIn: 'root'
})
export class RoleGuardService {

  constructor(private service: CafedetailsService, private deactiveStateRouter: Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    if (this.service.role() == "ADMIN") {
      return true;
    } else {
      if (this.service.role() == "USER") {
        this.deactiveStateRouter.navigate(['user']);
        return false;
      }
      this.deactiveStateRouter.navigate(['login']);
      return false;
    }

  }
}
