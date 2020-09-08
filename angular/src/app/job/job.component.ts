import { Component, OnInit } from '@angular/core';
import {AppService} from '../app.service';

@Component({
  selector: 'app-home',
  templateUrl: './job.component.html',
  styleUrls: ['./job.component.css'],
  providers: [AppService]
})
export class HomeComponent implements OnInit {
  title = 'Welcome to Base2 Angular';
  displayPage= 'home';
  arr = [];
  count = 1;
  constructor(private _service: AppService) {
    console.log("welcome constructor");
  }
  ngOnInit() {
    this._service.getMethod().subscribe(result => {
      console.log("response",result);
    })
    for(let i=0;i<10;i++) {
      this.arr.push(i)
    }
    console.log(this.arr);
    this.getData();
    this.count = (this.arrResource != null && this.arrResource.length > 0) ? this.arrResource.length+1 : 1; 
  }
  arrResource:any = [];
  resource = {
    id: 0,
    jobTitle: '',
    description: '',
    wageRange: ''
  }

  getValue() {
    if(this.resource.id == 0) {
      this.resource.id = this.count;
    this.count++;
    this._service.save("/job",this.resource).subscribe(result => {
      console.log("response",result);
    })
    this.arrResource.push(this.resource);
    localStorage.setItem('resourceInfo',JSON.stringify(this.arrResource));
    sessionStorage.setItem('resourceInfo',JSON.stringify(this.arrResource));
    alert("successfully Stored");
    this.resetFormValue();
    //this.getInfoList("/job");
    } else {
      this.sendData(this.resource);
    }
  }

  getData() {
    this._service.save("/job",this.resource).subscribe(result => {
      this.arrResource = result;
    })
    
  }

  resetFormValue() {
    this.resource = {
      id:null,
      jobTitle: '',
      description: '',
      wageRange: ''
    }
  }

  sendData(data) {
    console.log("edit",data);
    this.resource = JSON.parse(JSON.stringify(data));
    let clone = JSON.parse(JSON.stringify(this.arrResource));
    clone.forEach((a,i) => {
      if(this.resource.id == a.id) {
        clone[i] = this.resource
      }
    })  
    this.arrResource = JSON.parse(JSON.stringify(clone));
    localStorage.setItem('resourceInfo',JSON.stringify(this.arrResource));
  }

  deleteItem(data) {
    console.log('deleteItem',data);
    let clone = JSON.parse(JSON.stringify(this.arrResource));
    clone.forEach((a,i) => {
      console.log('actual',a);
      if(data.id == a.id) {
        clone.splice(i,1);
      }
    })
    this.arrResource = clone;
    localStorage.setItem('resourceInfo',JSON.stringify(this.arrResource));
  }


}
