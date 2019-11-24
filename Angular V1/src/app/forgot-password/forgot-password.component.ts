import { Component, OnInit } from '@angular/core';
import { CafedetailsService } from '../cafedetails/cafedetails.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  empId:string;
  newpass:string;
  result:boolean;
  question:string;
  answer:string;

  constructor(private service:CafedetailsService,private route:Router) { }

  ngOnInit() {
  }

  getQuestion(){
    console.log(this.empId);
    this.service.getQuestion(this.empId).subscribe(data=>{
      this.question=data;
      console.log(this.question);
    });
  }

  forgotPassword(){
    console.log(this.result);
    this.service.forgotPassword(this.empId,this.answer,this.newpass).subscribe(data=>{
      this.result=data;
      console.log(this.result);
      if(this.result == true){
        alert("password successfully changed");
        this.route.navigate(['login']);
      } else {
        alert("password not changed");
      }
    });
  }

  login(){
    this.route.navigate(['login']);
  }

}
