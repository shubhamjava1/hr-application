import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PipeTypeComponent } from './pipe-type.component';

describe('PipeTypeComponent', () => {
  let component: PipeTypeComponent;
  let fixture: ComponentFixture<PipeTypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PipeTypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PipeTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
