import { Component, OnInit } from '@angular/core';
import {MockObject} from "../../../class/mock-object";

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

  public model!:MockObject;
  public testArray:MockObject[]=[];

  constructor() { }

  ngOnInit(): void {
    // get data from server

  }

  onSubmit() {

  }
}
