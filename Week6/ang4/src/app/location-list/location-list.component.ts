import { Component, Input } from '@angular/core';
import { Location } from './location';
@Component({
  selector: 'app-location-list',
  templateUrl: './location-list.component.html',
  styleUrls: ['./location-list.component.css']
})
export class LocationListComponent {
  @Input() locations: Location[] =[];
}
