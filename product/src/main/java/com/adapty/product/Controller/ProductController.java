package com.adapty.product.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adapty.product.Service.ProductImpl;
import com.adapty.product.entities.Product;

@RestController
public class ProductController {

    @Autowired
    private ProductImpl srv;

    @GetMapping(value ="/api/allproducts")
    public List<Product> findAllProduct(){
        return srv.findAllProduct();
    }
    @GetMapping(value="/api/deleteproduct/{id}")
    public Optional<Product> findProductByproductId(@PathVariable("id") String productId)
    {
        return srv.findProductByproductId(productId);
    }
    @PostMapping(value="/api/postproduct")
    public String addProduct(@RequestBody Product ProductObj){
        return srv.addProduct(ProductObj);
    }
    @PutMapping(value="/api/updateproduct/{id}")
    public Product updateProductById(@PathVariable("id") Product obj){
        return srv.updateProductById(obj);
    }

    @DeleteMapping(value = "/api/deleteproduct/{id}")
    public String deleteProductById(@PathVariable("id") Product productObj)
    {
        return srv.deleteProductById(productObj);
    }


}

    
