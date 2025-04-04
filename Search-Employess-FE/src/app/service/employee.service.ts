import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../models/employee.model';
import { Department } from '../models/department.model';
import { Country } from '../models/country.model';
import { Region } from '../models/region.model';
import { Locations } from '../models/location.model';
import { observableToBeFn } from 'rxjs/internal/testing/TestScheduler';


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

  searchEmployees(dati_form: any): Observable<Employee[]> {
    const params = new HttpParams()
        .set('id_dipartimento', dati_form.id_dipartimento?.toString() || '')
        .set('id_location', dati_form.id_location?.toString() || '')
        .set('id_country', dati_form.id_country?.toString() || '')
        .set('nome_employee', dati_form.nome_employee || '')
        .set('id_region', dati_form.id_region?.toString() || '')
        .set('max_salary', dati_form.max_salary?.toString() || '')
        .set('min_salary', dati_form.min_salary?.toString() || '');
    return this.http.get<Employee[]>(`${baseUrl}/search`, { params }); 
  }

  DeleteEmployee(id:number):Observable<Employee[]>{
    return this.http.delete<Employee[]>(`${baseUrl}/employee/${id}`);
  }

  getEmployee(id:any): Observable<Employee>{
    return this.http.get<Employee>(`${baseUrl}/employee/${id}`);
  }

  updateEmployee(id: any, nome: any, salary: any): Observable<Employee> {
    console.log(`Updating employee ${id} with nome: ${nome} and salary: ${salary}`);
  
    const params = new HttpParams()
      .set('nome', nome)
      .set('salary', salary.toString()); // Assicurati che salary sia una stringa se è un numero
  
    return this.http.put<Employee>(`${baseUrl}/employee/${id}`, null, { params });
  }

  crateEmployee(nome:any , salary:any): Observable<Employee> {
    
    const params = new HttpParams()
      .set('last_name', nome)
      .set('salary', salary.toString()); // Assicurati che salary sia una stringa se è un numero

    return this.http.post<Employee>(`${baseUrl}/newemployee`,null, {params});
  }
  
  

}
