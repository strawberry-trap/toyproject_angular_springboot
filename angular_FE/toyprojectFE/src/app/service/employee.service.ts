import {Injectable} from '@angular/core';
import {HttpClient, HttpInterceptor} from "@angular/common/http";
import {Observable} from "rxjs";
import {Employee} from "../class/employee";
import {HttpinterceptorService} from "./interceptor/httpinterceptor.service";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseURL: String = "http://localhost:8080/api/v1/";
  private httpInterceptor:HttpInterceptor = new HttpinterceptorService();

  constructor(private httpclient: HttpClient) { }

  getEmployeeList(): Observable<Employee[]> {
    return this.httpclient.get<Employee[]>(`${this.baseURL}` + 'employeeList');
  }

  createEmployee(employee: Employee): Observable<Object> {
    return this.httpclient.post(`${this.baseURL}` + 'createEmployee', employee);
  }

  getEmployeeById(id: number): Observable<Employee> {
    return this.httpclient.get<Employee>(`${this.baseURL}` + `employee/${id}`);
  }

  updateEmployee(id: number, employee: Employee): Observable<Object> {
    return this.httpclient.put(`${this.baseURL}` + `updateEmployee/${id}`, employee);
  }

  deleteEmployee(id: number) {
    return this.httpclient.post(`${this.baseURL}` + `deleteEmployee/${id}`, id);
  }
}
