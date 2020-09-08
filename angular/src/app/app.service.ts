import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class AppService {
  info = "Date and time of this Component";
  baseurl = 'http://localhost:8080/hroperations';
  constructor(private _http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
  showDate() {
    let date = new Date();
    return date;
  }

  getMethod() {
    return this._http.get("http://www.json-generator.com/api/json/get/bVetNNuNNK")
  }

  getInfoList(url) {
    return this._http.get(this.baseurl + url);
  }

 
  save(url, data) {
    return this._http.post(this.baseurl + url, JSON.stringify(data), this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.errorHandl)
    )
  } 
  
  // Error handling
  errorHandl(error) {
    let errorMessage = '';
    if(error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
 }
}
