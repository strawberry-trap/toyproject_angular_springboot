import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeListComponent } from './employee-list.component';

describe('EmployeeListComponent', () => {
  let component: EmployeeListComponent;
  let fixture: ComponentFixture<EmployeeListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  // should expect data to have at least one record (fetched from database)
  it('should fetch data from server when initiated', ()=> {
    component.ngOnInit();
    expect(component.employees.length).toBeGreaterThan(1);
  });

  // timer should execute and can be subscribed
  it('should start timer when initiated', () => {
    component.ngOnInit();

    // basic assert and test
    component.timer.subscribe((value)=>{
      expect(value).toBeTruthy();
    });

  });
});
