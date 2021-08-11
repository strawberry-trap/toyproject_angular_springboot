import {Employee} from "./employee";

export class Work {

  id!: number;
  pay: number = 0;
  name: string='';
  description: string='';
  dueDate: Date = new Date();
}
