import { Component, OnInit } from '@angular/core';
import { TrainingDetails } from '../model/trainingdetails';
import { DataService } from '../service/data.service';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-tracker-training-page',
  templateUrl: './tracker-training-page.component.html',
  styleUrls: ['./tracker-training-page.component.css']
})
export class TrackerTrainingPageComponent implements OnInit {
  trainingDetails: TrainingDetails[] = [];
  trainingDetailsForm: FormGroup;
  trainingDetail: TrainingDetails;
  constructor(public fb: FormBuilder,
              public dataservice: DataService,
              private router: Router) { }

  ngOnInit() {
    this.dataservice.getAllTraingDetails().subscribe((data: TrainingDetails[]) => {
      this.trainingDetails = data;
    });
  }
  deleteTraining(id){
    this.dataservice.deleteTraining(id).subscribe();
    console.log('sucessfully deleted');
    window.location.reload();
  }

  updateTrainingById(id){
    this.dataservice.updateTraining(id).subscribe();
  }

  updateTraining(trainingdetails){
    this.router.navigateByUrl('tracker-create-trainingDetails');
    this.dataservice.updateTraining(trainingdetails).subscribe(res => {
    this.router.navigateByUrl('tracker-training-page');
    });
  }
  getByTrainingDetailsId(id){
    window.localStorage.removeItem('editTrainingId');
    window.localStorage.setItem('editTrainingId', id.toString());
    this.router.navigateByUrl('tracker-edit-training');
  }
}
