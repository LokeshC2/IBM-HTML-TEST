import { Component, Input } from '@angular/core';
import { Employee } from './employee';
@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent {
   @Input() employees: Employee[] = [];
}
