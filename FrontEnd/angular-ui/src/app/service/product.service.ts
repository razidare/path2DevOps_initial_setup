import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

export interface Product {
  id: number;
  name: string;
  price: {
    amount: number;
    currency: string;
  }
}

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = "/product";
  constructor(private http: HttpClient) { }

  getProducts(): Observable<Product[]> {
    const products = [];
    // products.push(
    //   {
    //     "id": 7,
    //     "name": "yellowBeard",
    //     "price": {
    //         "amount": 9.99,
    //         "currency": "EUR"
    //     }
    // },
    // {
    //   "id": 8,
    //   "name": "redBeard",
    //   "price": {
    //       "amount": 9.99,
    //       "currency": "EUR"
    //   }
    // }
    // )
    return this.http.get<Product[]>(environment.productUrl);
  }
}
