import { Component, OnInit, } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Department } from './department-list/department';
import { Employee } from './employee-list/employee';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  httpClient:HttpClient;
  departments: Department[] = [] 
  employees: Employee[] = []

  constructor(httpClient: HttpClient) {
    this.httpClient = httpClient
  }

  title = 'ang4';

  ngOnInit() {
    this.httpClient.get<Department[]>("url").subscribe(data => this.departments = data)
    this.httpClient.get<Employee[]>("url").subscribe(data => this.employees = data)
  }
}