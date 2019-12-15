import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddUpdateMobilComponent } from './add-update-mobil.component';

describe('UpdateMobilComponent', () => {
  let component: AddUpdateMobilComponent;
  let fixture: ComponentFixture<AddUpdateMobilComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddUpdateMobilComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddUpdateMobilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
