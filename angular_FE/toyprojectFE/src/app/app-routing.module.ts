import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {EmployeeListComponent} from "./component/employee-list/employee-list.component";
import {EmployeeCreateComponent} from "./component/employee-create/employee-create.component";
import {EmployeeUpdateComponent} from "./component/employee-update/employee-update.component";
import {EmployeeDeleteComponent} from "./component/employee-delete/employee-delete.component";

const routes: Routes = [
  {path: "employees", component: EmployeeListComponent},
  {path: "create-employee", component: EmployeeCreateComponent},
  {path: "update-employee/:id", component: EmployeeUpdateComponent},
  {path: "delete-employee/:id", component: EmployeeDeleteComponent},
  {path: "**", redirectTo: "employees", pathMatch: "full"}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
