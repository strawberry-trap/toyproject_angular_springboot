import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeListComponent } from './component/employee-list/employee-list.component';
import {HttpClientModule} from "@angular/common/http";
import { EmployeeCreateComponent } from './component/employee-create/employee-create.component';
import {FormsModule} from "@angular/forms";
import { EmployeeUpdateComponent } from './component/employee-update/employee-update.component';
import { EmployeeDeleteComponent } from './component/employee-delete/employee-delete.component';

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
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
