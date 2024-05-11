import { Component } from '@angular/core';
import { FormControl, FormGroup, Validator, Validators } from '@angular/forms';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-add-account',
  templateUrl: './add-account.component.html',
  styleUrls: ['./add-account.component.css']
})
export class AddAccountComponent {
constructor(private _AdminService:AdminService,private _Router:Router,private _AuthService:AuthService){ }

  isLoading:boolean=false;
  apiError:string='';
  addAccountForm:FormGroup=new FormGroup({
    accountNumber:new FormControl(null,[Validators.required]),
    nationalId:new FormControl(null,[Validators.required]),
    balance:new FormControl(null,[Validators.required]), 
  });
  handleAddAccount(addAccountForm:FormGroup){
    this.isLoading=true;
    if(addAccountForm.valid)
    {
      console.log(addAccountForm.value)
      this._AdminService.addAccount(addAccountForm.value).subscribe({
        next:(res)=>{
          console.log(res)
          if(res){
            this.isLoading=false;
            this._Router.navigate(['home/add-account'])
            alert(res.body)
          }
        },
        error:(err)=>{
          // console.log(err);
          
          this.isLoading=false;
          // this.apiError=err.error.errors.msg;
      }
      })
    }

  }
}
