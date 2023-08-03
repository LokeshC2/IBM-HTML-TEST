import { Location } from "../location-list/location";

export class Department {
  constructor(
    public name: string,
    private _location: Location
  ) {}
  
  public get location(): string {
    return this._location.name+', ' + this._location.city;
  }
}
