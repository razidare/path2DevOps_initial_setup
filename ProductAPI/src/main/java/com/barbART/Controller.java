package com.barbART;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@CrossOrigin
public class Controller {
    
    @Autowired
    private ProductRepository productRepository;

    @CrossOrigin
    @GetMapping("/product")
    public List<Product> index(){
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public Product show(@PathVariable String id){
        int productId = Integer.parseInt(id);
        return productRepository.findOne(productId);
    }

    @GetMapping("/product/search")
    public List<Product> search(@RequestParam("query") String body){
        return productRepository.findByNameContaining(body);
    }

    @PostMapping("/product")
    public Product create(@RequestBody Product product){
        return productRepository.save(product);
    }

    @PutMapping("/product")
    public Product update(@RequestBody Product product){
        return productRepository.save(product);
    }

    @DeleteMapping("/product/{id}")
    public boolean delete(@PathVariable String id){
        int productId = Integer.parseInt(id);
        productRepository.delete(productId);
        return true;
    }


}