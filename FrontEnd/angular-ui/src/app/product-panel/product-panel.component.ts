import { Component, OnInit, Input } from '@angular/core';
import { Product } from '../service/product.service';
import { CartService } from '../service/cart.service';

@Component({
  selector: 'app-product-panel',
  templateUrl: './product-panel.component.html',
  styleUrls: ['./product-panel.component.scss'],
  // template: `
  // <nav class="navbar">
  //   <!--logo-->
  //   <div class="navbar-brand">
  //     <a class="navbar-item">
  //       <img src="assets/img/blue_officeGuy.jpg">
  //     </a>
  //   </div>
  // </nav>
  // `
})
export class ProductPanelComponent implements OnInit {

  @Input()
  public product: Product;

  constructor(private cartService: CartService) { }

  ngOnInit() {
  }

  buyNow(){
    this.cartService.getCart().subscribe(response => {
      console.log(response)
      alert(response);
    })
  }
}
