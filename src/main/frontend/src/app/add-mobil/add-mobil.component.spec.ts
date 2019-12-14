import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddMobilComponent } from './add-mobil.component';

describe('AddMobilComponent', () => {
  let component: AddMobilComponent;
  let fixture: ComponentFixture<AddMobilComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddMobilComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddMobilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
