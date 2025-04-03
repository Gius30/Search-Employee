import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../service/employee.service';
import { ActivatedRoute } from '@angular/router';
import { Employee } from '../models/employee.model';

@Component({
  selector: 'app-detail-employee',
  templateUrl: './detail-employee.component.html',
  styleUrl: './detail-employee.component.css'
})
export class DetailEmployeeComponent implements OnInit {

  currentEmployee: Employee | undefined;

  constructor(private employeeService: EmployeeService, private route: ActivatedRoute) { console.log('EmployeeService inizializzato'); } // Log per debug 

  ngOnInit(): void {
    const id = this.route.snapshot.params['id'];
    if (id) {
      this.getEmployee(id);
    } else {
      console.error('ID non valido'); // Log per debug
    }
  }

  getEmployee(id: number): void {
    this.employeeService.getEmployee(id).subscribe({
      next : (employee) => {
        this.currentEmployee = employee;
        console.log("Dipendente caricato correntamente!!");
      },
      error:(error)=>{
        console.log("errore durante la fase di caricamento del dipendente: ",error);
      }
    });
  }


}
