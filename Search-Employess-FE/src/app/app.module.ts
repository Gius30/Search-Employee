import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { SearchFormComponent } from './dashboard/search-form/search-form.component';
import { ResultTableComponent } from './dashboard/result-table/result-table.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    SearchFormComponent,
    ResultTableComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
