package com.adapty.product.Controller;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adapty.product.Service.CartImpl;
import com.adapty.product.entities.Cart;

@RestController
public class CartController {

    @Autowired
    private CartImpl srvCart;

    @GetMapping(value ="/api/cart")
    public ArrayList findAll(){
        return srvCart.findAll();
    }
    @PostMapping(value ="/api/addnewcart")
    public String AddObjToCart(@RequestBody Cart cartObj){
        return srvCart.AddObjToCart(cartObj);
    }
   
    @DeleteMapping(value = "/api/delete/cartproduct/{cartItemID}")
    public String  deleteByCartID(@PathVariable String cartItemID){
        return srvCart.deleteByCartID(cartItemID);
    }
    @PutMapping(value="/api/modify/{cartItemId}")
    public Cart updateCartByItemId(@RequestBody Cart  cartItemId){
        return srvCart.updateCartByItemId(cartItemId);
    }
    @DeleteMapping(value = "/api/item/{productId}")
    public String deleteCartByProductId(@PathVariable String productId){
    return srvCart.deleteCartByProductId(productId);
    }
    

   
}
