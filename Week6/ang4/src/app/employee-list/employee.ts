import { Department } from '../department-list/department';
export class Employee {
  constructor(
   public id: string,
   public firstname: string,
   public lastname: string,
   public email: string,
   private _department: Department
  ) {}

  public get department(): string {
    return this._department.name;
  }
  public get location(): string {
    return this._department.location;
  }
}
