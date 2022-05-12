import { Component } from '@angular/core';
import { ProductService, Product } from './service/product.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'gigi';
  products: Product[] = [];

  constructor(private productService: ProductService) {
    this.productService.getProducts().subscribe(products => {
      this.products = products;
    });
    console.log(this.products);
  }
}
