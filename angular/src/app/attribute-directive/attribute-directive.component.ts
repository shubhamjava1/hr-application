import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'sunny',
  templateUrl: './attribute-directive.component.html',
  styleUrls: ['./attribute-directive.component.css']
})
export class AttributeDirectiveComponent implements OnInit {
  attributeType;
  _hide: boolean = false;
  _displayContent = 'Hide'
  ngForExample = ['orange','red','green','blue'];
  constructor() { }

  ngOnInit() {
  }

  _hideShowContent() {
    this._hide = !this._hide;
    this._displayContent = (this._hide) ? 'Show' : 'Hide';
    
    // if(this._hide) {
    //   this._displayContent = 'show';
    // } else {
    //   this._displayContent = 'Hide';
    // }
  }

}
