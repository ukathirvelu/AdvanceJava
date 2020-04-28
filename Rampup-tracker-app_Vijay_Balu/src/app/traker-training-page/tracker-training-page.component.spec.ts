import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrackerTrainingPageComponent } from './tracker-training-page.component';

describe('TrackerTrainingPageComponent', () => {
  let component: TrackerTrainingPageComponent;
  let fixture: ComponentFixture<TrackerTrainingPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrackerTrainingPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrackerTrainingPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
