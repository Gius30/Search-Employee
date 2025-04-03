import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { SearchFormComponent } from './dashboard/search-form/search-form.component';
import { DetailEmployeeComponent } from './detail-employee/detail-employee.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    SearchFormComponent,
    DetailEmployeeComponent,
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
