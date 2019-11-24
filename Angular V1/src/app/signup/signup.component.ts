import { Component, OnInit } from '@angular/core';
import { Employee } from '../model/employee.model';
import { Router } from '@angular/router';
import { CafedetailsService } from '../cafedetails/cafedetails.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  employee:Employee;
  questions:string[]=['First mobile ?','Favourite pet ?','Your spouse name ?','Time of birth ?'];

  constructor(private service:CafedetailsService, private route:Router) { 
    this.employee= new Employee();
  }

  ngOnInit() {
  }

  signup(){
    this.service.signup(this.employee).subscribe(data => this.employee=data);
    console.log(this.employee);
    this.employee=new Employee();
    this.route.navigate(['login']);
  }

  login(){
    this.route.navigate(['login']);
  }

}
