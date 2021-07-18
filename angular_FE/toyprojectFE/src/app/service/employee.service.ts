import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Employee} from "../class/employee";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseURL: String = "http://localhost:8080/api/v1/employeeList";

  constructor(private httpclient: HttpClient) { }

  getEmployeeList(): Observable<Employee[]> {
    return this.httpclient.get<Employee[]>(`${this.baseURL}`);
  }
}
