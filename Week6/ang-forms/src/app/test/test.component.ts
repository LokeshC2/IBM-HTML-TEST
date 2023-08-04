import { Component, OnInit } from '@angular/core';

import { TestData } from './test-data';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

  testData = new TestData(
    1,                    // Id
    'My Name',            // Name
    'My Comments',        // Comments
    'Blue',               // Favorite Color
    'Spring',             // Favorite Season
    [false, true, true, false], // Hobbies
  );

  colors  = ['Red', 'Blue', 'Yellow', 'Purple', 'Orange', 'Green'];
  seasons = ['Spring', 'Summer', 'Autumm', 'Winter'];
  hobbies = ['Reading', 'Writing', 'Painting', 'Walking'];

  constructor() { }

  ngOnInit() {
  }

  onSubmit() {
    alert(
      JSON.stringify(this.testData)
    );
  }

}