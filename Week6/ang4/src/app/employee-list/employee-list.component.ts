import { Component, Input } from '@angular/core';
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

   }
}
