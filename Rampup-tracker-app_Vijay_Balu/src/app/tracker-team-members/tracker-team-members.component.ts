import { Component, OnInit, ViewChild } from '@angular/core';
import { DataService } from '../service/data.service';
import { TeamMembers } from '../model/teammembers';
import { MatDialog } from '@angular/material/dialog';
import { MatTable } from '@angular/material/table';
import { DialogBoxComponent } from './dialog-box/dialog-box.component';

@Component({
  selector: 'app-tracker-team-members',
  templateUrl: './tracker-team-members.component.html',
  styleUrls: ['./tracker-team-members.component.css']
})
export class TrackerTeamMembersComponent implements OnInit {

  teammembers = [];
  tableColumns  :  string[] = ['id','firstName', 'lastName', 'phone', 'email', 'action'];
  highlightedRow = [];
  id : number ;
  @ViewChild(MatTable) mytable: MatTable<TeamMembers>;
  
  constructor(public dataService: DataService,
    public dialog : MatDialog) {
   }

  ngOnInit(): void {
    this.dataService.getRequest().subscribe((data : TeamMembers[]) =>{
      console.log(data);
      this.teammembers = data;
    });
  }

  openDialog(action,obj) {
    obj.action = action;
    const dialogRef = this.dialog.open(DialogBoxComponent, {
      width: '500px',
      data:obj
    });

    dialogRef.afterClosed().subscribe(result => {
      if(result.event == 'Add'){
        this.addMember(result.data);
      }else if(result.event == 'Update'){
        this.updateMember(result.data);
      }else if(result.event == 'Delete'){
        this.deleteMember(result.data);
      }
    });
  }

  addMember(row_obj){
    console.log(row_obj);
    this.dataService.addTeamMember(row_obj).subscribe(res =>{
      this.ngOnInit();
      console.log("Team Member added");
    });
    console.log(this.mytable.dataSource);
    this.mytable.renderRows();
  }

  updateMember(row_obj: TeamMembers){
    this.dataService.update(row_obj.id, row_obj).subscribe(res=>{
      this.ngOnInit();
      console.log('Team Member updated')
    });
  }

  deleteMember(row_obj){
    this.dataService.deleteMember(row_obj.id).subscribe(res=>{
      this.ngOnInit();
      console.log('Team Member Deleted');
    });
  }

}
