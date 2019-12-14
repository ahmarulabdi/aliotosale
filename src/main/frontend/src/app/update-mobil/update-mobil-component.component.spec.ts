import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateMobilComponentComponent } from './update-mobil-component.component';

describe('UpdateMobilComponentComponent', () => {
  let component: UpdateMobilComponentComponent;
  let fixture: ComponentFixture<UpdateMobilComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateMobilComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateMobilComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
