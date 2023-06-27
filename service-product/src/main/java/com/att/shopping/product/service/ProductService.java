package com.att.shopping.product.service;

import com.att.shopping.product.entity.Category;
import com.att.shopping.product.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    List< Product > listAllProduct();
    Product getProduct( Long id );
    Product createProduct( Product product );
    Product updateProduct( Product product );
    Product deleteProduct( Long id );
    List< Product > findByCategory(Category category );
    Product updateStock( Long id, int quantity );

}
