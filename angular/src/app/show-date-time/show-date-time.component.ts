import { Component, OnInit } from '@angular/core';
import {AppService} from '../app.service';

@Component({
  selector: 'app-show-date-time',
  templateUrl: './show-date-time.component.html',
  styleUrls: ['./show-date-time.component.css'],
  providers: [AppService]
})
export class ShowDateTimeComponent implements OnInit {
  date;
  message;
  constructor(private _service: AppService) { }

  ngOnInit() {
    this.date = this._service.showDate();
    this.message = this._service.info;
  }

}
