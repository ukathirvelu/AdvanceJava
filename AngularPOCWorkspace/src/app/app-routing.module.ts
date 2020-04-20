import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddTeamMembersComponent } from './team-members/add-team-members/add-team-members.component';
import { ViewTeamMembersComponent } from './team-members/view-team-members/view-team-members.component';


const routes: Routes = [
  {path:'secondPage',component:ViewTeamMembersComponent},
  {path:'add-team-members',component:AddTeamMembersComponent},
  //{path : '', component : }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
