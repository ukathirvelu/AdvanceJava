import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrackerCreateTrainingdetailsComponent } from './tracker-create-trainingdetails.component';

describe('TrackerCreateTrainingdetailsComponent', () => {
  let component: TrackerCreateTrainingdetailsComponent;
  let fixture: ComponentFixture<TrackerCreateTrainingdetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrackerCreateTrainingdetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrackerCreateTrainingdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
