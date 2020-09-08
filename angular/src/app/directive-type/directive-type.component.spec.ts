import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DirectiveTypeComponent } from './directive-type.component';

describe('DirectiveTypeComponent', () => {
  let component: DirectiveTypeComponent;
  let fixture: ComponentFixture<DirectiveTypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DirectiveTypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DirectiveTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
