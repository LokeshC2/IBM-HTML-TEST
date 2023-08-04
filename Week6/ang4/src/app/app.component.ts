import { Component } from '@angular/core';
import { Employee } from './employee-list/employee';
import { Department } from './department-list/department';
import { Location } from './location-list/location';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ang4';
  locations: Location[] = [
    new Location("Bg1", "Banglore"),
    new Location("Bg2", "Banglore"),
    new Location("Kt1", "Kolkata"),
    new Location("Mm1", "Mumbai")
  ];
  
  departments: Department[] =[
    new Department("IT", this.locations[0]),
    new Department("Sales", this.locations[1]),
    new Department("Research", this.locations[2])
   ]

   employees: Employee[] = [
     new Employee(141,"Van", "Hohenheim", "s23@xerxes.fm", this.departments[2]),
     new Employee(23,"Roy", "Mustang", "flame@amestris.fm", this.departments[1]),
     new Employee(12,"Ling", "Yao", "prince@xing.fm", this.departments[0])
   ]
}

