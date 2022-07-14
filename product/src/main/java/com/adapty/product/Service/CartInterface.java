package com.adapty.product.Service;
import java.util.ArrayList;


import com.adapty.product.entities.Cart;

public interface CartInterface {
    public ArrayList findAll();
    public String AddObjToCart(Cart cartObj);
    public String deleteByCartID(String cartItemId);
    public Cart updateCartByItemId(Cart cartObj);
    public String deleteCartByProductId(String productId);
    

}
