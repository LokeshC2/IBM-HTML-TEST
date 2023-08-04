import { Component, Input, Output } from '@angular/core';
import { Employee } from './employee';
import { Department } from '../department-list/department';
@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent {
   @Input() employees: Employee[] = [];
   @Input() departments: Department[] = [];

   firstname: string = ""
   lastname: string = ""
   email: string = ""
   department: Department | null = null;
   
   addEmployee(result: any) {
    let id = Math.max(...this.employees.map(e=>e.id))+1
    this.employees.push(new Employee(id, result.firstname, result.lastname, result.email, result.department))
   }
}
