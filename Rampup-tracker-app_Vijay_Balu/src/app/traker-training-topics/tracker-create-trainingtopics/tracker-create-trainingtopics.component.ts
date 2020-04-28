import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { DataService } from '../../service/data.service';
import { TrainingDetails } from '../../model/trainingdetails';

@Component({
  selector: 'app-tracker-create-trainingtopics',
  templateUrl: './tracker-create-trainingtopics.component.html',
  styleUrls: ['./tracker-create-trainingtopics.component.css']
})
export class TrackerCreateTrainingtopicsComponent implements OnInit {
  topicDetailsForm: FormGroup;
  trainingDetails = [];
  
  constructor(public fb: FormBuilder,
              private router: Router,
              public dataService: DataService) { 
              }

  ngOnInit() {
    this.topicDetailsForm = this.fb.group({
      topicName: ['', Validators.required],
      description: ['', Validators.required],
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
      trainingDetails:['',Validators.required]
    });
    this.dataService.getAllTraingDetails().subscribe((data: TrainingDetails[]) =>
      {
        console.log("sdada"+data.length);
        this.trainingDetails = data;
        console.log("Trainings"+this.trainingDetails);
        console.log("Trainings"+this.trainingDetails.length);
        console.log("asasas"+this.topicDetailsForm.value);
    })
    
  
  }

  submitForm() {
    if (this.topicDetailsForm.invalid) {
      console.log('Please enter all details');
      return;
    }
    this.dataService.createTopic(this.topicDetailsForm.value).subscribe(res => {
      console.log('Training topic created!');
      this.router.navigateByUrl('tracker-training-topic');
    });
  }

}
