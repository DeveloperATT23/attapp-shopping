package com.att.shopping.product.service;

import com.att.shopping.product.entity.Category;
import com.att.shopping.product.entity.Product;
import com.att.shopping.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepository productRepository;
    @Override
    public List<Product> listAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById( id ).orElse( null );
    }

    @Override
    public Product createProduct(Product product) {

        product.setStatus( "CREATED");
        product.setCreatedAt( new Date() );

        Product newProduct = productRepository.save( product );

        return newProduct;
    }

    @Override
    public Product updateProduct(Product product) {
        Product productDB = getProduct( product.getId() );
        if ( null == productDB ) {
            return null;
        }

        productDB.setName( product.getName() );
        productDB.setDescription( product.getDescription() );
        productDB.setPrice( product.getPrice() );
        productDB.setStock( product.getStock() );
        productDB.setStatus( product.getStatus() );
        productDB.setCategory( product.getCategory() );
        productDB.setCreatedAt( product.getCreatedAt() );

        return productRepository.save( productDB );
    }

    @Override
    public Product deleteProduct(Long id) {
        Product productDB = getProduct( id );
        if ( null == productDB ) {
            return null;
        }

        productDB.setStatus( "DELETED" );
        return productRepository.save( productDB );
    }

    @Override
    public List<Product> findByCategory( Category category ) {
        return productRepository.findByCategory( category );
    }

    @Override
    public Product updateStock(Long id, int quantity) {

        Product productDB = getProduct( id );
        if ( null == productDB ) {
            return null;
        }

        int stock = productDB.getStock() + quantity;

        productDB.setStock( stock );
        return productRepository.save( productDB );
    }
}
