export class Address {
  public addressLine1: string;
  public addressLine2: string;
  public city: string;

  constructor(l1: string, l2: string, ct: string) {
    this.addressLine1 = l1;
    this.addressLine2 = l2;
    this.city = ct;
  }
}
