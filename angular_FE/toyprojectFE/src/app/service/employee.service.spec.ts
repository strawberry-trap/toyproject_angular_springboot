import { TestBed } from '@angular/core/testing';

import { EmployeeService } from './employee.service';
import {Observable} from "rxjs";

describe('EmployeeService', () => {
  let service: EmployeeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EmployeeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  // server should return at least one record
  it('should fetch data from server', () =>{
    service.getEmployeeList().subscribe((value)=>{
      expect(value.length).toBeGreaterThan(1);
    });
  });
});
