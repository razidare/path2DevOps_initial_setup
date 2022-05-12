package com.barbART;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CartController {

    @CrossOrigin
    @GetMapping("/cart")
    public String index(){
        return "Oops! Functionality under development, please order by mail at: `str.Lalelelor nr. 32 060234 Bucharest, Romania` ";
    }    
}