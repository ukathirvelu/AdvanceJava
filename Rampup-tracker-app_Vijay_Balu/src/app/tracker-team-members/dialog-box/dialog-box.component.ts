import { Component, OnInit, Optional, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { TeamMembers } from 'src/app/model/teammembers';
import {FormControl, Validators} from '@angular/forms';

@Component({
  selector: 'app-dialog-box',
  templateUrl: './dialog-box.component.html',
  styleUrls: ['./dialog-box.component.css']
})
export class DialogBoxComponent implements OnInit {

  action:string;
  local_data: TeamMembers;
  email = new FormControl('', [Validators.required, Validators.email]);
  constructor(public dialogRef: MatDialogRef<DialogBoxComponent>,
    //@Optional() is used to prevent error if no data is passed
    @Optional() @Inject(MAT_DIALOG_DATA) public data: TeamMembers) { 
      console.log(data);
      this.local_data = {...data};
      this.action = this.local_data.action;
    }

    getErrorMessage() {
      if (this.email.hasError('required')) {
        return 'You must enter a value';
      }
  
      return this.email.hasError('email') ? 'Not a valid email' : '';
    }

    doAction(){
      this.dialogRef.close({event:this.action,data:this.local_data});
    }
  
    closeDialog(){
      this.dialogRef.close({event:'Cancel'});
    }
  
    ngOnInit(): void {   
    }
}
