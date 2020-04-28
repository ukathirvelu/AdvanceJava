import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrackerTopicsEditComponent } from './tracker-topics-edit.component';

describe('TrackerTopicsEditComponent', () => {
  let component: TrackerTopicsEditComponent;
  let fixture: ComponentFixture<TrackerTopicsEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrackerTopicsEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrackerTopicsEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
