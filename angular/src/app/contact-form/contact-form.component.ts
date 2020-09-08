import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http'

@Component({
  selector: 'jill',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent implements OnInit {
  departmentList;
  profile = {
    id: 0,
    vendorCompany: '',
    vendorRepName: '',
    vendorRepEmail: '',
    nameOfCandiate: '',
    jobPost:{
      id:0
    }
  }

  constructor(private _http: HttpClient) { }

  ngOnInit() {
    this.getDepartList();
  }

  _submit(){
    this._http.post('http://localhost:8081/deparment/save',this.departmentObj).subscribe(result => {
      console.log(result);
      this.getDepartList();
      this.resetForm();
    })
  }

  getDepartList() {
    this._http.get('http://localhost:8081/deparment//get-all-departments').subscribe(result => {
      this.departmentList = result;
    })
  }


  resetForm() {
    this.departmentObj = {
      id: 0,
      name: '',
      code: '',
      status: ''
    }
  }

}
