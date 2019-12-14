import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TableMobilComponent } from './table-mobil.component';

describe('TableMobilComponent', () => {
  let component: TableMobilComponent;
  let fixture: ComponentFixture<TableMobilComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableMobilComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableMobilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
