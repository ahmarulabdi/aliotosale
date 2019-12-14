import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TableMobilComponentComponent } from './table-mobil-component.component';

describe('TableMobilComponentComponent', () => {
  let component: TableMobilComponentComponent;
  let fixture: ComponentFixture<TableMobilComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableMobilComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableMobilComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
