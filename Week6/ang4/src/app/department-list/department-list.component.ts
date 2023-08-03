import { Component, Input } from '@angular/core';
import { Department } from './department';

@Component({
  selector: 'app-department-list',
  templateUrl: './department-list.component.html',
  styleUrls: ['./department-list.component.css']
})
export class DepartmentListComponent {
  @Input() departments: Department[]=[];
}
