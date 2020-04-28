import { Component, OnInit, ViewChild } from '@angular/core';
import { DataService } from '../service/data.service';
import { TrainingDetails } from '../model/trainingdetails';
import { TrainingTopics } from '../model/trainingtopics';
import { MatTable ,MatTableDataSource} from '@angular/material/table';
import { Router } from '@angular/router';
import { TeamMembers } from '../model/teammembers';


@Component({
  selector: 'app-tracker-home',
  templateUrl: './tracker-home.component.html',
  styleUrls: ['./tracker-home.component.css']
})
export class TrackerHomeComponent implements OnInit {

  panelOpenState = false;
  trainings : TrainingDetails[];
  inProgressTrainings : TrainingDetails[] = [];
  completedTrainings:TrainingDetails[] = [];
  yetToStartTrainings:TrainingDetails[] = [];
  total: number;
  today = new Date();
  columnsToDisplay  :  string[] = ['id','trainingName', 'startDate', 'endDate', 'progress'];
  @ViewChild(MatTable) mytable: MatTable<TrainingDetails>;
  countofTeammembers : number;
  //datasource: MatTableDataSource<TrainingDetails>;
  
  constructor(private dataservice: DataService,
   private router: Router) { }
  
  ngOnInit(): void {
    this.dataservice.getAllTraingDetails().subscribe((data: TrainingDetails[])=> {
      this.trainings = data;
      console.log('Data ::::',this.trainings);
      this.inProgressTrainings = this.getInProgressTrainings(this.trainings);
      console.log('Inprogress: ', this.inProgressTrainings);
      ///this.datasource = new MatTableDataSource<TrainingDetails>(this.inProgressTrainings);
      this.completedTrainings = this.getCompletedTrainings(this.trainings);
      this.yetToStartTrainings = this.getYetToStartTrainings(this.trainings);
      this.total = this.trainings.length;
      this.dataservice.getRequest().subscribe((data : TeamMembers[]) =>{
        console.log(data);
        this.countofTeammembers = data.length;
      });
    }); 
  }
  getYetToStartTrainings(trainings: TrainingDetails[]): TrainingDetails[] {
    this.trainings.forEach(row => {
      if(this.today < new Date(row.startDate)){
        console.log('yest');
        this.yetToStartTrainings.push(row);
        console.log(this.yetToStartTrainings);
      }
    });
    return this.yetToStartTrainings;
  }
  getCompletedTrainings(trainings: TrainingDetails[]): TrainingDetails[] {
    this.trainings.forEach(row => {
      if(this.today > new Date(row.endDate)){
        console.log('completed');
        this.completedTrainings.push(row);
        console.log(this.completedTrainings);
      }
    });
    return this.completedTrainings;
  }
  getInProgressTrainings(trainings: TrainingDetails[]):TrainingDetails[] {
    this.trainings.forEach( row => {
      if (this.today > new Date(row.startDate) && this.today < new Date(row.endDate)){
        row.progress = ((this.today.getDate() - new Date(row.startDate).getDate()) /
                          (new Date(row.endDate).getDate() - new Date(row.startDate).getDate())) * 100;
        this.inProgressTrainings.push(row);
        this.dataservice.getTopicsByTrainingDetailsId(row.id).subscribe(data =>{
          row.numberofTopics = data.length;
        });
        }
      });
      console.log(this.inProgressTrainings);
    return this.inProgressTrainings;
  }
  
  }

