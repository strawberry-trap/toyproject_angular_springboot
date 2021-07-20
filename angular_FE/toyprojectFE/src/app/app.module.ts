import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeListComponent } from './component/employee-list/employee-list.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import { EmployeeCreateComponent } from './component/employee-create/employee-create.component';
import {FormsModule} from "@angular/forms";
import { EmployeeUpdateComponent } from './component/employee-update/employee-update.component';
import { EmployeeDeleteComponent } from './component/employee-delete/employee-delete.component';
import {HttpinterceptorService} from "./service/interceptor/httpinterceptor.service";

@NgModule({
  declarations: [
    AppComponent,
    EmployeeListComponent,
    EmployeeCreateComponent,
    EmployeeUpdateComponent,
    EmployeeDeleteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],

  // added interceptor in providers
  providers: [{provide: HTTP_INTERCEPTORS, useClass: HttpinterceptorService, multi:true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
