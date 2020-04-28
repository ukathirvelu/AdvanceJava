import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrackerTeamMembersComponent } from './tracker-team-members.component';

describe('TrackerTeamMembersComponent', () => {
  let component: TrackerTeamMembersComponent;
  let fixture: ComponentFixture<TrackerTeamMembersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrackerTeamMembersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrackerTeamMembersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
