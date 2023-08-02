import { Department } from "./Department";
 
export class Employee
{
    constructor(private firstName:string,private lastName:string,department:Department)
    {
 
    }
 
    public getDetails():string
    {
        return'first name: '+this.firstName+' last name: '+this.lastName;
    }
}