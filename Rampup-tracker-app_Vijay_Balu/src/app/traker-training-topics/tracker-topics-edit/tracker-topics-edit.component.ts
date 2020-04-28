import { Component, OnInit } from '@angular/core';
import { TrainingTopics } from '../../model/trainingtopics';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { DataService } from '../../service/data.service';
import { TrainingDetails } from '../../model/trainingdetails';

@Component({
  selector: 'app-tracker-topics-edit',
  templateUrl: './tracker-topics-edit.component.html',
  styleUrls: ['./tracker-topics-edit.component.css']
})
export class TrackerTopicsEditComponent implements OnInit {
  trainingTopic: TrainingTopics;
  editTopicForm: FormGroup;
  trainingDetails = [];
  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private dataService: DataService) { }

  ngOnInit() {

    const topicId = window.localStorage.getItem('editTopicId');
    console.log('Topic Id:::' + topicId);
    if (!topicId) {
      alert('Invalid action.');
      this.router.navigate(['tracker-training-topic']);
      return;
    }
    this.editTopicForm = this.formBuilder.group({
      id: [''],
      topicName: ['', Validators.required],
      description: ['', Validators.required],
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
      trainingDetails:['']
    });
    this.dataService.getAllTraingDetails().subscribe((data: TrainingDetails[]) =>
      {
        console.log("sdada"+data.length);
        this.trainingDetails = data;
        console.log("Trainings"+this.trainingDetails);
        console.log("Trainings"+this.trainingDetails.length);
        console.log("asasas"+this.editTopicForm.value);
    })
    this.dataService.getByTopicDetailsId(topicId)
      .subscribe( data => {
        this.editTopicForm.setValue(data);
    });
  }

  submitForm() {
    if (this.editTopicForm.invalid) {
      console.log('Please enter all details');
      return;
    }
    console.log("id:::"+this.editTopicForm.get('id'));
    this.dataService.updateTopic(this.editTopicForm.value).subscribe(res => {
      console.log('Training topic updated!');
      this.router.navigateByUrl('tracker-training-topic');
    });
  }

}
