import { Department } from '../department-list/department';
import { Location } from '../location-list/location';
export class Employee {
  constructor(
   public id: number = 0,
   public firstname: string = "",
   public lastname: string = "",
   public email: string = "",
   public department: Department = new Department()
  ) {}

  public get departmentName(): string {
    return "Department of" + this.department.name;
  }

  public get locationName(): string {
    return this.department.locationName;
  }
}
