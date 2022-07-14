package com.adapty.product.ServiceTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matcher;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.adapty.product.Repository.CartRepository;
import com.adapty.product.Repository.ProductRepository;
import com.adapty.product.Service.CartImpl;
import com.adapty.product.Service.ProductImpl;
import com.adapty.product.entities.CATEGORY;
import com.adapty.product.entities.Cart;
import com.adapty.product.entities.Product;
import com.adapty.product.entities.STATUS;


@ExtendWith(MockitoExtension.class)
public class CartServiceTesting {
    @InjectMocks
    CartImpl  CartImplObj;
    @InjectMocks
    ProductImpl productImpl;
    @Mock
    CartRepository CartRepoObj;
    @Mock 
    ProductRepository productRepoObj;

    //fetch all carts
    /@Test
//     public void findAll(){
//         ArrayList list = new ArrayList();
//         Cart c1=new Cart("1", 2, "2");
//         Product p1=new Product("2", "vivo", CATEGORY.ELECTRONICS,10000, "8GB RAM", "url/image", STATUS.ACTIVE);
//         list.add(c1);
//         list.add(p1);
//         int totalPrice=(c1.getCartItemQty() * p1.getProductPrice());
//         list.add(totalPrice);
//         when(CartRepoObj.findAll()).thenReturn(list);
//         assertEquals(1, list.size());
//         verify(list,times(3)).findAll();
       
        
//  } 
    
    
   


    //Add to cart
    @Test
    public void AddObjToCart(){
    Cart c1=new Cart("1", 50, "1");
    CartRepoObj.save(c1);
    verify(CartRepoObj,times(1)).save(c1);
    }

    //Delete cart by cartID
    @Test
    public void deleteByCartID(){
        Cart c1 = new Cart("c1", 50, "1");
        lenient().when(CartRepoObj.findById("c1")).thenReturn(Optional.of(c1));
        String msg=CartImplObj.deleteByCartID("c1");
        assertEquals("Cart object deleted successfully",msg);
        
    }
    //Update Cart by cart
    @Test
    public void updateCartByItemId(){
        Cart c1=new Cart("2", 10, "2");
    
        c1.setCartItemQty(4);
        c1.setProductId("2");


        Assertions.assertThat(c1.getCartItemQty()).isEqualTo(4);
        Assertions.assertThat(c1.getProductId()).isEqualTo("2");
        }

    //Delete By Cart By product ID
    @Test
    public void deleteCartByProductById(){
        Cart c1 = new Cart("1", 50, "1");
        lenient().when(CartRepoObj.findById("1")).thenReturn(Optional.of(c1));
        String msg=CartImplObj.deleteCartByProductId("1");
        assertEquals( "Product Id in cart deleted successfully.",msg);
        }
}


