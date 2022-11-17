import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class SignupService {
  private baseUrl: String = "http://localhost:8080"

  constructor(private http: HttpClient) {
  }

  signUp(info: any) {
    return this.http.post(`${this.baseUrl}/auth/register/`, info)
  }

}
