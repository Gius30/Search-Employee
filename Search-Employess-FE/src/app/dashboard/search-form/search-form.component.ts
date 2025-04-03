import { Component, OnInit } from '@angular/core';
import { Country } from '../../models/country.model';
import { Department } from '../../models/department.model';
import { Locations } from '../../models/location.model';
import { Region } from '../../models/region.model';
import { EmployeeService } from '../../service/employee.service';
import { Employee } from '../../models/employee.model';



@Component({
  selector: 'app-search-form',
  templateUrl: './search-form.component.html',
  styleUrl: './search-form.component.css'
})
export class SearchFormComponent implements OnInit {



  //dati dove metto i dati che mi arrivano dal servizio
  dati_form = {
    id_dipartimento: null, // ID del dipartimento
    id_location: null, // ID della location
    id_country: null, // ID del paese
    nome_employee: '', // Nome del dipendente
    id_region: null, // ID della regione
    max_salary: null, // Massimo stipendio
    min_salary: null // Minimo stipendio
  };

  //dichiarazione variabili
  departments: Department[] = []; //dichiarazione array di tipo Department
  regions: Region[] = []; //dichiarazione array di tipo Region
  countries: Country[] = []; //dichiarazione array di tipo Country
  locations: Locations[] = []; //dichiarazione array di tipo Location
  employees: Employee[] = []; //dichiarazione array di tipo Employee

  //prendo i dati dal servizio
  constructor(private employeeService: EmployeeService) {console.log('EmployeeService inizializzato');} // Log per debug 

  ngOnInit(): void {
    console.log('SearchFormComponent inizializzato'); // Log per debug
    this.caricaCampi(); //chiamo il metodo per caricare i campi
  }

  caricaCampi() {
    this.employeeService.getAllDepartments().subscribe({
      next: (data) => {
        console.log('Dati dipartimenti ricevuti:', data);
        this.departments = data; //carico i dati nel array dipartimento
        console.log('Dipartimenti caricati:', this.departments);
      },
      error: (error) => {
        console.error('Errore nel recupero dati dipartimento', error); //gestione errore
      }
    });

    this.employeeService.getAllRegions().subscribe({
      next: (data) => {
      this.regions = data; //carico i dati nel array region
      },
      error: (error) => {
      console.error('Errore nel recupero dati regione', error); // gestione errore
      },
      complete: () => {
      console.log('Caricamento regioni completato'); // messaggio di completamento
      }
    });

    this.employeeService.getallCountries().subscribe({
      next: (data) => {
        this.countries = data; //carico i dati nel array region
      },
      error: (error) => {
        console.error('Errore nel recupero dati countries', error); //gestione errore
      }
    });

    this.employeeService.getallLocations().subscribe({
      next: (data) => {
        this.locations = data.map((location: any) => ({
          id: location.id,
          name_loc: location.city
        })); // Trasformo i dati per includere solo id e city

      },
      error: (error) => {
        console.error('Errore nel recupero dati location', error); //gestione errore
      }
    });
    
    this.employeeService.getAllEmployees().subscribe({
      next: (data) => {
        this.employees = data; //carico i dati nel array employee
      },
      error: (error) => {
        console.error('Errore nel recupero dati employee', error); //gestione errore
      }
    });
  }

  onSubmit() {
    
  }

}
