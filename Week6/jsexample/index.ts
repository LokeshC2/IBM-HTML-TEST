import { Address } from "./Address";
import { Doctor } from "./Doctor";
import { Person } from "./Person";

let address = new Address("green street", "red town", "blue city")
let person = new Person('John', 'Doe', 'john2email.com');
person._address = address
person._firstName = 'Sachin';
console.log(person._firstName);
let doctor = new Doctor(person._firstName, person._lastName, person._email, "ABC1021325");
doctor._address = person._address;

console.log(doctor);

import { RegularEmployee } from "./RegularEmployee";
 
person=new Person('John','Doe','john@email.com');
person._address = new Address('India','Kolkata', "Howrah")
let employee=new RegularEmployee(10000,'John','Doe');
console.log(person, employee)