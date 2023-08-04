import { Location } from "../location-list/location";

export class Department {
  constructor(
  public name: string = "",
  public location: Location = new Location()
  ) {}

  public get locationName(): string {
    return this.location.name + ', ' + this.location.city; 
  }

}
