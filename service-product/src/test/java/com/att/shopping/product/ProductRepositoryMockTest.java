package com.att.shopping.product;

import com.att.shopping.product.entity.Category;
import com.att.shopping.product.entity.Product;
import com.att.shopping.product.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class ProductRepositoryMockTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenFindByCategory_thenReturnListProduct() {

        Product product01 = Product.builder()
                .name("Quantum Computer")
                .category( Category.builder().id(1L).build() )
                .description( "Brand New  Quantum Computer" )
                .stock( Integer.parseInt( "10" ))
                .price( Double.parseDouble( "1234.99" ))
                .status( "Created" )
                .createdAt( new Date() ).build();

        productRepository.save( product01 );

        List<Product> founded = productRepository.findByCategory( product01.getCategory() );


        Assertions.assertEquals( founded.size(), 3);

    }
}
