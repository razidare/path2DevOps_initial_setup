import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

export interface Cart {
}

@Injectable({
  providedIn: 'root'
})
export class CartService
 {

  private baseUrl = "/cart";
  constructor(private http: HttpClient) { }

  getCart(): Observable<string> {
 
    return this.http.get(environment.cartUrl, {responseType: 'text'});
  }
}
