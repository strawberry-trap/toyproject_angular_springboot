import { Component, OnInit } from '@angular/core';
import {EmployeeService} from "../../service/employee.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Employee} from "../../class/employee";

@Component({
  selector: 'app-employee-delete',
  templateUrl: './employee-delete.component.html',
  styleUrls: ['./employee-delete.component.css']
})
export class EmployeeDeleteComponent implements OnInit {

  employee: Employee = new Employee();
  id: number = 0;

  constructor(private employeeService: EmployeeService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {

    // get employee id from currently activated route
    this.id = this.activatedRoute.snapshot.params['id'];

    // same logic in different code
    // this.activatedRoute.queryParams.subscribe(params => {
    //   this.id = params['id'];
    // });

    // to show the deleting employee's information
    this.employeeService.getEmployeeById(this.id).subscribe(data => {
      this.employee = data;
    }, error => console.log(error));
  }

    // double-check modal for delete action
    public modal: boolean = false;
    triggerModal() {
      if (this.modal == false) this.modal = true;
      else this.modal = false;
    }

  onSubmit() {
    // show modal for delete double-check
    this.triggerModal();
  }

  public goToEmployeeList() {
    this.router.navigate(['/employees']);
  }

  // user clicks "delete anyway" in modal
  proceedDelete() {

    // dismiss modal
    this.triggerModal();

    // execute delete process
    this.employeeService.deleteEmployee(this.id).subscribe(data => {
      this.goToEmployeeList();}, error => console.log(error));
  }
}
