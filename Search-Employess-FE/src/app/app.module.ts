import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { SearchFormComponent } from './dashboard/search-form/search-form.component';
import { DetailEmployeeComponent } from './detail-employee/detail-employee.component';
import { NewEmployeeComponent } from './new-employee/new-employee.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    SearchFormComponent,
    DetailEmployeeComponent,
    NewEmployeeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
