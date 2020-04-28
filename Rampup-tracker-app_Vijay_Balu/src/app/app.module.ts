import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { TrackerHomeComponent } from './tracker-home/tracker-home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/Input';
import { MatProgressBarModule} from '@angular/material/progress-bar';
import { MatCardModule} from '@angular/material/card';
import { TrackerTeamMembersComponent } from './tracker-team-members/tracker-team-members.component';
import { MatTableModule } from '@angular/material/table';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DialogBoxComponent } from './tracker-team-members/dialog-box/dialog-box.component';
import { MatDialogModule } from '@angular/material/dialog';
import { TrackerTopicsEditComponent } from './traker-training-topics/tracker-topics-edit/tracker-topics-edit.component';
import { TrackerCreateTrainingtopicsComponent } from './traker-training-topics/tracker-create-trainingtopics/tracker-create-trainingtopics.component';
import { TrackerTrainingEditComponent } from './traker-training-page/tracker-training-edit/tracker-training-edit.component';
import { TrackerCreateTrainingdetailsComponent } from './traker-training-page/tracker-create-trainingdetails/tracker-create-trainingdetails.component';
import { TrackerTrainingTopicsComponent } from './traker-training-topics/tracker-training-topics.component';
import { TrackerTrainingPageComponent } from './traker-training-page/tracker-training-page.component';
import { MatExpansionModule } from '@angular/material/expansion';

 
@NgModule({
  declarations: [
    AppComponent,
    TrackerHomeComponent,
    TrackerTeamMembersComponent,
    DialogBoxComponent,
    TrackerTrainingPageComponent,
    TrackerTrainingTopicsComponent,
    TrackerCreateTrainingdetailsComponent,
    TrackerTrainingEditComponent,
    TrackerCreateTrainingtopicsComponent,
    TrackerTopicsEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatInputModule,
    MatProgressBarModule,
    MatCardModule,
    MatTableModule,
    MatFormFieldModule,
    FormsModule,
    ReactiveFormsModule,
    MatDialogModule,
    MatExpansionModule
  ],
  entryComponents: [
    DialogBoxComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
