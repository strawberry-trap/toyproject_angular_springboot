import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  // data from server
  model!: any;

  // data for dropdown options
  options: Object[] = [];

  constructor() { }

  ngOnInit(): void {

  }

  // executes when form is submitted
  onSubmit() {

  }
}
