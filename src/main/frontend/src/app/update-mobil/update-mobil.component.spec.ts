import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateMobilComponent } from './update-mobil.component';

describe('UpdateMobilComponent', () => {
  let component: UpdateMobilComponent;
  let fixture: ComponentFixture<UpdateMobilComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateMobilComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateMobilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
