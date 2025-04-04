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
  isEditing: boolean = false; //stato per mostrare/nascondere il form
  currentEmployee: Employee | undefined;

  constructor(private employeeService: EmployeeService, private route: ActivatedRoute) { console.log('EmployeeService inizializzato'); } // Log per debug 

  ngOnInit(): void {
    const id = +this.route.snapshot.params['id'];
    if (id) {
      this.getEmployee(id);
    } else {
      console.error('ID non valido'); // Log per debug
    }
  }

  getEmployee(id: number): void {
    this.employeeService.getEmployee(id).subscribe({
      next: (employee) => {
        this.currentEmployee = employee;
        console.log("Dipendente caricato correntamente!!");
      },
      error: (error) => {
        console.log("errore durante la fase di caricamento del dipendente: ", error);
      }
    });
  }

  toggleEditForm(): void {
    this.isEditing = !this.isEditing; // Alterna la visibilità del form
  }

  updateEmployee(): void {
    console.log('Metodo update chiamato');
    if (this.currentEmployee) {
      this.employeeService.updateEmployee(this.currentEmployee.id, this.currentEmployee.first_name , this.currentEmployee.salary).subscribe({
        next: (updatedEmployee) => {
          this.currentEmployee = updatedEmployee;
          console.log('Dipendente aggiornato con successo!');
          this.isEditing = false; // Nascondi il form dopo l'aggiornamento
        },
        error: (error) => {
          console.error('Errore durante l\'aggiornamento del dipendente:', error);
        }
      });
    }
  }


}
