package com.barbART;

import java.util.ArrayList;
import java.util.List;

public class ProductsMockData {
    //list of products
    private List<Product> products;

    private static ProductsMockData instance = null;
    public static ProductsMockData getInstance(){
         if(instance == null){
             instance = new ProductsMockData();
         }
         return instance;
    }


    public ProductsMockData(){
        products = new ArrayList<Product>();
        products.add(new Product(1, "blueBeard",new Amount(9.99,"EUR")));
        products.add(new Product(2, "redBeard",new Amount(10.15,"EUR")));
        products.add(new Product(3, "greenBeard",new Amount(10.15,"EUR")));
        products.add(new Product(4, "silverBeard",new Amount(11.99,"EUR")));
        products.add(new Product(5, "goldBeard",new Amount(13.45,"EUR")));
        
    }

    // return all products
    public List<Product> fetchProducts() {
        return products;
    }

    // return product by id
    public Product getProductById(int id) {
        for(Product p: products) {
            if(p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // search product by name
    public List<Product> searchProducts(String searchTerm) {
        List<Product> searchedProducts = new ArrayList<Product>();
        for(Product p: products) {
            if(p.getName().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchedProducts.add(p);
            }
        }

        return searchedProducts;
    }

    // create product
    public Product createProduct(int id, String name, Amount price) {
        Product newProduct = new Product(id, name, price);
        products.add(newProduct);
        return newProduct;
    }

    // update product
    public Product updateProduct(int id, String name, Amount price) {
        for(Product p: products) {
            if(p.getId() == id) {
                int productIndex = products.indexOf(p);
                p.setName(name);
                p.setPrice(price);
                products.set(productIndex, p);
                return p;
            }

        }

        return null;
    }

    // delete product by id
    public boolean delete(int id){
        int productIndex = -1;
        for(Product p: products) {
            if(p.getId() == id) {
                productIndex = products.indexOf(p);
                continue;
            }
        }
        if(productIndex > -1){
            products.remove(productIndex);
        }
        return true;
    }

}