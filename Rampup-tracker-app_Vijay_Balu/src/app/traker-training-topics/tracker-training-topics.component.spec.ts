import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrackerTrainingTopicsComponent } from './tracker-training-topics.component';

describe('TrakerTrainingTopicsComponent', () => {
  let component: TrackerTrainingTopicsComponent;
  let fixture: ComponentFixture<TrackerTrainingTopicsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrackerTrainingTopicsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrackerTrainingTopicsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
