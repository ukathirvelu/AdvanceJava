import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrackerTrainingEditComponent } from './tracker-training-edit.component';

describe('TrackerTrainingEditComponent', () => {
  let component: TrackerTrainingEditComponent;
  let fixture: ComponentFixture<TrackerTrainingEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrackerTrainingEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrackerTrainingEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
