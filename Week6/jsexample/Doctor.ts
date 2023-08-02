import { Person } from "./Person";

export class Doctor extends Person {
  private _certificateNo: string;

  constructor(_firstName: string, _lastName: string, _email: string, certNo: string) {
    super(_firstName, _lastName, _email);
    this._certificateNo = this.checkCertNo(certNo);
  }

  public get certificateNo(): string {
    return this._certificateNo;
  }

  public set certificateNo(certNo: string) {
    this._certificateNo = this.checkCertNo(certNo);
  }

  public checkCertNo(certNo: string) {
    if (certNo.startsWith("ABC") && certNo.length == 10) {
      return certNo;
    } else throw Error("Invalid Cert No");

  }
}
