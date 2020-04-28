import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrackerCreateTrainingtopicsComponent } from './tracker-create-trainingtopics.component';

describe('TrackerCreateTrainingtopicsComponent', () => {
  let component: TrackerCreateTrainingtopicsComponent;
  let fixture: ComponentFixture<TrackerCreateTrainingtopicsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrackerCreateTrainingtopicsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrackerCreateTrainingtopicsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
