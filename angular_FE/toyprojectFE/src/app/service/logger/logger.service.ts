import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoggerService {

  public logConsole(msg: any) {
    console.log("[" + new Date() + "] : " + msg);
  }
  constructor() { }
}
