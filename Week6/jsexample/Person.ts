import { Address } from "./Address";

export class Person {
  private firstName: string;
  private lastName: string;
  private email: string;
  private address: Address | undefined;
  constructor(_firstName: string, _lastName: string, _email: string) {
    this.firstName = _firstName;
    this.lastName = _lastName;
    this.email = _email;
  }

  public get _firstName(): string {
    return this.firstName;
  }
  public set _firstName(_firstName: string) {
    this.firstName = _firstName;
  }

  public get _lastName(): string {
    return this.lastName;
  }

  public set _lastName(_lastName: string) {
    this.lastName = _lastName;
  }

  public get _email(): string {
    return this.email;
  }

  public set _email(_email: string) {
    this.email = _email;
  }

  public get _address(): Address | null {
    return this.address || null;
  }

  public set _address(_address: Address) {
    this.address = _address;
  }

}
