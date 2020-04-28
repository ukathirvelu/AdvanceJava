import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { DataService } from '../../service/data.service';


@Component({
  selector: 'app-tracker-create-trainingdetails',
  templateUrl: './tracker-create-trainingdetails.component.html',
  styleUrls: ['./tracker-create-trainingdetails.component.css']
})
export class TrackerCreateTrainingdetailsComponent implements OnInit {

  trainingDetailsForm: FormGroup;

  constructor(public fb: FormBuilder,
              private router: Router,
              public dataService: DataService) { }

  ngOnInit(): void {
    this.trainingDetailsForm = this.fb.group({
      trainingName: ['', Validators.required],
      topic: ['', Validators.required],
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
    });
  }

  submitForm() {
    if (this.trainingDetailsForm.invalid) {
      console.log('Please enter all details');
      return;
    }
    this.dataService.createTraining(this.trainingDetailsForm.value).subscribe(res => {
      console.log('Training topic created!');
      this.router.navigateByUrl('tracker-training-page');
    });
  }

}
