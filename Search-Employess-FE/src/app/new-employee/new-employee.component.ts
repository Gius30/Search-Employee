import { Component } from '@angular/core';
import { EmployeeService } from '../service/employee.service';
import { Employee } from '../models/employee.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-employee',
  templateUrl: './new-employee.component.html',
  styleUrl: './new-employee.component.css'
})
export class NewEmployeeComponent {

  dati_form = {
    nome: null,
    salary: null
  }

  constructor(private empServ: EmployeeService,private route: Router) { }

  onSubmit(): void {
    console.log("dati inviati per la creazione");
    this.empServ.crateEmployee(this.dati_form.nome, this.dati_form.salary).subscribe({
      next: () => { console.log("Dipendente creato");
        this.route.navigate(['/dashboard']);
      },error: (error) => {
        console.error('Errore durante l\'aggiunta del dipendente:', error);
      }
    });
  }


}
