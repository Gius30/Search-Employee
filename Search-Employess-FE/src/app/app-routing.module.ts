import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { DetailEmployeeComponent } from './detail-employee/detail-employee.component';
import { NewEmployeeComponent } from './new-employee/new-employee.component';

const routes: Routes = [
 {path: '', redirectTo: '/dashboard', pathMatch: 'full'},
 {path: 'dashboard', component: DashboardComponent},
 { path: 'employee/:id', component: DetailEmployeeComponent },
 { path: 'dashboard/newEmployee', component: NewEmployeeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
