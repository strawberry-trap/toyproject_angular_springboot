import { Component, OnInit } from '@angular/core';
import {Employee} from "../../class/employee";
import {EmployeeService} from "../../service/employee.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-employee-update',
  templateUrl: './employee-update.component.html',
  styleUrls: ['./employee-update.component.css']
})
export class EmployeeUpdateComponent implements OnInit {

  employee: Employee = new Employee();
  id: number = 0;

  constructor(private employeeService:EmployeeService,
              private activatedRoute: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    this.id = this.activatedRoute.snapshot.params['id'];
    this.employeeService.getEmployeeById(this.id).subscribe( data => {
      this.employee = data;
    }, error => console.log(error));
  }

  onSubmit() {
    this.employeeService.updateEmployee(this.id, this.employee).subscribe(data => {
      this.goToEmployeeList();
    }, error => console.log(error));
  }

  public goToEmployeeList() {
    this.router.navigate(['/employees']);
  }
}
