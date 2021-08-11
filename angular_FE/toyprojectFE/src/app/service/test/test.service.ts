import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {MockObject} from "../../class/mock-object";

@Injectable({
  providedIn: 'root'
})
export class TestService {

  private baseURL: String = "http://localhost:8080/api/v1/";

  constructor(private httpclient:HttpClient) { }


}
