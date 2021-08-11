import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeListComponent } from './component/employee/employee-list/employee-list.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import { EmployeeCreateComponent } from './component/employee/employee-create/employee-create.component';
import {FormsModule} from "@angular/forms";
import { EmployeeUpdateComponent } from './component/employee/employee-update/employee-update.component';
import { EmployeeDeleteComponent } from './component/employee/employee-delete/employee-delete.component';
import {HttpinterceptorService} from "./service/common/interceptor/httpinterceptor.service";
import { FormComponent } from './component/common/form/form.component';
import { TestComponent } from './component/common/test/test.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeListComponent,
    EmployeeCreateComponent,
    EmployeeUpdateComponent,
    EmployeeDeleteComponent,
    FormComponent,
    TestComponent
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
