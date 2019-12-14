import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddMobilComponentComponent } from './add-mobil-component.component';

describe('AddMobilComponentComponent', () => {
  let component: AddMobilComponentComponent;
  let fixture: ComponentFixture<AddMobilComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddMobilComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddMobilComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
