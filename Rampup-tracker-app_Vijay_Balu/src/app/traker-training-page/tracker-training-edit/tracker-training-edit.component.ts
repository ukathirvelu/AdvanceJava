import { Component, OnInit } from '@angular/core';
import { TrainingDetails } from '../../model/trainingdetails';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { DataService } from '../../service/data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-tracker-training-edit',
  templateUrl: './tracker-training-edit.component.html',
  styleUrls: ['./tracker-training-edit.component.css']
})
export class TrackerTrainingEditComponent implements OnInit {
  trainingDetail: TrainingDetails;
  editForm: FormGroup;
  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private dataService: DataService) { }

  ngOnInit() {
    const trainingId = window.localStorage.getItem('editTrainingId');
    console.log('Training Id:::' + trainingId);
    if (!trainingId) {
      alert('Invalid action.');
      this.router.navigate(['tracker-training-page']);
      return;
    }
    this.editForm = this.formBuilder.group({
      id: [''],
      trainingName: ['', Validators.required],
      topic: ['', Validators.required],
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
    });
    this.dataService.getByTrainingDetailsId(trainingId)
      .subscribe( data => {
        this.editForm.setValue(data);
      });

  }

  submitForm() {
    console.log('Inside submit form' );
    if (this.editForm.invalid) {
      console.log('Please enter all details');
      return;
    }
    this.dataService.updateTraining(this.editForm.value).subscribe(res => {
      console.log('Training topic updated!');
      this.router.navigateByUrl('tracker-training-page');
    });
  }

}
