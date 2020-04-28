import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrackerHomeComponent } from './tracker-home.component';

describe('TrackerHomeComponent', () => {
  let component: TrackerHomeComponent;
  let fixture: ComponentFixture<TrackerHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrackerHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrackerHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
