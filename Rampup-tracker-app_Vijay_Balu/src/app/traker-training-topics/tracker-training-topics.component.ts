import { Component, OnInit } from '@angular/core';
import { TrainingTopics } from '../model/trainingtopics';
import { DataService } from '../service/data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-tracker-training-topics',
  templateUrl: './tracker-training-topics.component.html',
  styleUrls: ['./tracker-training-topics.component.css']
})
export class TrackerTrainingTopicsComponent implements OnInit {

  trainingTopics: TrainingTopics[] = [];

  constructor(public dataService: DataService,
              private router: Router) {

               }

  ngOnInit(){
    console.log('inside componenet');
    this.dataService.getAllTraingTopics().subscribe((data: TrainingTopics[]) => {
      console.log('Data' + data.length);
      this.trainingTopics = data;
    });
  }


  deleteTopic(id){
    this.dataService.deleteTopic(id).subscribe();
    console.log('Topic deleted sucessfully');
    window.location.reload();
  }

  getByTopicDetailsId(id){
    console.log('get details');
    window.localStorage.removeItem('editTopicId');
    window.localStorage.setItem('editTopicId', id.toString());
    this.router.navigateByUrl('tracker-edit-topic');
  }

}
