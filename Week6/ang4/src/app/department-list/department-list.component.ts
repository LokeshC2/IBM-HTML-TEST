import { Component, Input } from '@angular/core';
import { Department } from './department';
import { Location } from '../location-list/location';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-department-list',
  templateUrl: './department-list.component.html',
  styleUrls: ['./department-list.component.css']
})
export class DepartmentListComponent {
  @Input() departments: Department[] = [];
  @Input() locations: Location[] = [];
  
  addDepartment(value: { departmentName: string; location: Location; }) {
    this.departments.push(new Department(value.departmentName, value.location))
  }

}
