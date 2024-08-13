import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';


@Injectable({
    providedIn: 'root'
})

export class StudentdetailsService {
    constructor(
        private http: HttpClient,
    ) { }


  BaseURL = environment.WEB_API;


  PostAllstudentdetailsValues(data:any){
    return this.http.post(`${this.BaseURL}/studentdetails`,data);
  }

  GetAllstudentdetailsValues(){
    return this.http.get(`${this.BaseURL}/studentdetails`);
  }

  Updatestudentdetails(data:any){
    return this.http.put(`${this.BaseURL}/studentdetails/${data.id}`,data);
  }

  getSpecificstudentdetails(id:number){
    return this.http.get(`${this.BaseURL}/studentdetails/${id}`);
  }

  getSpecificstudentdetailsHistory(id:number){
    return this.http.get(`${this.BaseURL}/studentdetails/${id}/history?days=30`);
  }

  DeletestudentdetailsValues(dataId:any){
     return this.http.delete(`${this.BaseURL}/studentdetails/${dataId}`);
  }

  GetEntityById(studentdetailsId:any): Observable<any> {
    return this.http.get(`${this.BaseURL}/studentdetailsid/` + studentdetailsId);
  }

  Searchstudentdetails(data:any): Observable<any> {
    const temp:any = [];
    const objectKeyPair = Object.entries(data);
    objectKeyPair.forEach((element, index) => {
    if (element[1]) {
    temp.push(`${element[0]}=${element[1]}`);
    }
    });
    let jwt_token = sessionStorage.getItem('JwtToken');
    return this.http.get(`${this.BaseURL}` + `/studentdetails/get/search?jwt_token=${jwt_token}${temp.length > 0 ? `&${temp.join('&')}` : ''}`);
  }
}