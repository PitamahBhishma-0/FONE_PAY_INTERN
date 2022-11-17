import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs";
@Injectable({
  providedIn: 'root'
})
export class ChartInService {
  baseUrl="http://localhost:8080/expertise/find"
  expertise:any;
  constructor(private http:HttpClient) {
  }
  expertises(){
    return this.http.get(`${this.baseUrl}`) ;
  }

      getExpertiseOnly(expertises:any){
          let expertise:string[]=[];
          for (const expertise of this.expertise.expertise){
                expertise.push(expertise.expertise);
          }

      }

  }


