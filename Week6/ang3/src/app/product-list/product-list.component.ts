import { Component } from '@angular/core';
import { Product } from './product';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent {
  products: Product[] = [
    new Product("123","Product1", 250, true),
    new Product("765","OtherProduct", 200, true),
    new Product("1627","Lastonegone", 350, false)
  ];
}
