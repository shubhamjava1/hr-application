import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowDateTimeComponent } from './show-date-time.component';

describe('ShowDateTimeComponent', () => {
  let component: ShowDateTimeComponent;
  let fixture: ComponentFixture<ShowDateTimeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowDateTimeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowDateTimeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
