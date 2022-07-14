package com.adapty.product.Service;

import java.util.List;
import java.util.Optional;

import com.adapty.product.entities.Product;
public interface ProductInterface {
    public List<Product> findAllProduct();
    public Optional<Product>  findProductByproductId(String productId);
    //public Optional<Product>  findProductByproductName(String productName);
    public Product updateProductById(Product productObj);
    public String deleteProductById(Product productsObj);
    
}
