import {Component, OnDestroy, OnInit} from '@angular/core';
import {Employee} from "../../class/employee";
import {EmployeeService} from "../../service/employee.service";
import {ActivatedRoute, Router} from "@angular/router";
import {interval, Observable} from "rxjs";
import {tap} from "rxjs/operators";

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit, OnDestroy {

  employees: Employee[] = [];
  date: Date = new Date();

  timer: Observable<any> = interval(1000).pipe(
    tap(value => {
      this.date = new Date();
    })
  );

  // timeObservable$ = interval(1000).pipe(
  //   tap((value) => {
  //     this.date = new Date(); // update date
  //     console.log('second', value);
  //   })
  // );

  constructor(private employeeService: EmployeeService,
              private router: Router) { }

  ngOnInit(): void {
    this.getEmployeeList();

    // update current date every second, to show it in the template
    this.timer.subscribe();
  }

  ngOnDestroy(): void {

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
