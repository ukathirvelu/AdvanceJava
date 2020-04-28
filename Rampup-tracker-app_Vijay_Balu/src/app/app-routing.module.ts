import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TrackerHomeComponent } from './tracker-home/tracker-home.component';
import { TrackerTeamMembersComponent } from './tracker-team-members/tracker-team-members.component';
import { TrackerTrainingPageComponent } from './traker-training-page/tracker-training-page.component';
import { TrackerTrainingTopicsComponent } from './traker-training-topics/tracker-training-topics.component';
import { TrackerTrainingEditComponent } from './traker-training-page/tracker-training-edit/tracker-training-edit.component';
import { TrackerCreateTrainingdetailsComponent } from './traker-training-page/tracker-create-trainingdetails/tracker-create-trainingdetails.component';
import { TrackerCreateTrainingtopicsComponent } from './traker-training-topics/tracker-create-trainingtopics/tracker-create-trainingtopics.component';
import { TrackerTopicsEditComponent } from './traker-training-topics/tracker-topics-edit/tracker-topics-edit.component';

const routes: Routes = [
  {path:'', redirectTo:'tracker-home', pathMatch:'full'},
  {path: 'tracker-home', component: TrackerHomeComponent},
  {path: 'tracker-team-members', component: TrackerTeamMembersComponent},
  {path: 'tracker-training-page', component: TrackerTrainingPageComponent},
  {path: 'tracker-training-topic',component: TrackerTrainingTopicsComponent},
  {path: 'tracker-edit-training', component: TrackerTrainingEditComponent},
  {path: 'tracker-create-trainingDetails', component: TrackerCreateTrainingdetailsComponent},
  {path: 'tracker-create-trainingtopic', component: TrackerCreateTrainingtopicsComponent},
  {path: 'tracker-edit-topic', component: TrackerTopicsEditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
