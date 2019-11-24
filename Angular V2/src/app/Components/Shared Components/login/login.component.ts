import { Component, OnInit } from '@angular/core';
import { Employee } from '../../../model/employee.model';
import { CafedetailsService } from '../../../Services/cafedetails/cafedetails.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  employee: Employee;
  empId: string;
  password: string;

  constructor(private service: CafedetailsService, private route: Router) { }

  ngOnInit() {
  }

  login() {
    this.service.login(this.empId, this.password).subscribe(data => {
      this.employee = data;
      this.service.saveEmployee(this.employee);
      if (this.employee.employeeRole == "USER") {
        sessionStorage.setItem('role', this.employee.employeeRole);
        this.route.navigate(['user-cafedetails']);
      } else if (this.employee.employeeRole == "ADMIN") {
        sessionStorage.setItem('role', this.employee.employeeRole);
        this.route.navigate(['admin-home']);
      }
    });
  }

  navigateSignup() {
    this.route.navigate(['signup']);
  }

  navigateForgotPassword() {
    this.route.navigate(['forgotpassword']);
  }

}
