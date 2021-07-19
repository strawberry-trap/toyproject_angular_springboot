import { Component, OnInit } from '@angular/core';
import {Employee} from "../../class/employee";
import {EmployeeService} from "../../service/employee.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees: Employee[]=[];

  constructor(private employeeService: EmployeeService,
              private router: Router) { }

  ngOnInit(): void {
    this.getEmployeeList();
  }

  private getEmployeeList() {
    this.employeeService.getEmployeeList().subscribe(data => {
      this.employees = data;
    });
  }

  public updateEmployee(id: number) {
    this.router.navigate(['update-employee', id]);
  }

  public deleteEmployee(id: number) {
    this.router.navigate(['delete-employee', id]);
  }
}
