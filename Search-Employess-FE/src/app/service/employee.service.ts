import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../models/employee.model';
import { Department } from '../models/department.model';
import { Country } from '../models/country.model';
import { Region } from '../models/region.model';
import { Locations } from '../models/location.model';


const baseUrl = 'http://localhost:8080/api';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http:HttpClient) { }

  getAllEmployees():Observable<Employee[]> {
    return this.http.get<Employee[]>(`${baseUrl}/employees`);
  }
  getAllDepartments():Observable<Department[]> {
    return this.http.get<Department[]>(`${baseUrl}/departments`);
  }
  getallCountries():Observable<Country[]> {
    return this.http.get<Country[]>(`${baseUrl}/countries`);
  }
  getallLocations():Observable<Locations[]> {
    return this.http.get<Locations[]>(`${baseUrl}/locations`);
  }
  getAllRegions():Observable<Region[]> {
    return this.http.get<Region[]>(`${baseUrl}/regions`);
  }

}
