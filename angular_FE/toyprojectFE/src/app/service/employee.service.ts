import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Employee} from "../class/employee";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseURL: String = "http://localhost:8080/api/v1/";

  constructor(private httpclient: HttpClient) { }

  getEmployeeList(): Observable<Employee[]> {
    return this.httpclient.get<Employee[]>(`${this.baseURL}` + 'userList');
  }

  createEmployee(employee: Employee): Observable<Object> {
    return this.httpclient.post(`${this.baseURL}` + 'createUser', employee);
  }

  getEmployeeById(id: number): Observable<Employee> {
    return this.httpclient.get<Employee>(`${this.baseURL}` + `employee/${id}`);
  }

  updateEmployee(id: number, employee: Employee): Observable<any> {
    return this.httpclient.put(`${this.baseURL}` + `updateUser/${id}`, employee);
  }

  deleteEmployee(id: number) {
    return this.httpclient.post(`${this.baseURL}` + `deleteUser/${id}`, id);
  }
}
