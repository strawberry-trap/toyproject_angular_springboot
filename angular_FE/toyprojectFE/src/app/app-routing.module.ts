import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {EmployeeListComponent} from "./component/employee/employee-list/employee-list.component";
import {EmployeeCreateComponent} from "./component/employee/employee-create/employee-create.component";
import {EmployeeUpdateComponent} from "./component/employee/employee-update/employee-update.component";
import {EmployeeDeleteComponent} from "./component/employee/employee-delete/employee-delete.component";
import {TestComponent} from "./component/common/test/test.component";

const routes: Routes = [
  {path: "employees", component: EmployeeListComponent},
  {path: "create-employee", component: EmployeeCreateComponent},
  {path: "update-employee/:id", component: EmployeeUpdateComponent},
  {path: "delete-employee/:id", component: EmployeeDeleteComponent},
  {path: "test", component: TestComponent},
  {path: "**", redirectTo: "employees", pathMatch: "full"}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
