import { Component } from '@angular/core';
import { SalesPerson } from './sales-person';

@Component({
  selector: 'app-sales-person-list',
  templateUrl: './sales-person-list.component.html',
  styleUrls: ['./sales-person-list.component.css']
})
export class SalesPersonListComponent {
  sales_people: SalesPerson [] = [
    new SalesPerson('John', 'Dover', 3000),
    new SalesPerson('Joseph', 'Bro', 5000),
    new SalesPerson('Carlos', 'Mia', 1200)
  ];
}
