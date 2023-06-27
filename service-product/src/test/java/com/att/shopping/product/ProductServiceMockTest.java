package com.att.shopping.product;

import com.att.shopping.product.entity.Category;
import com.att.shopping.product.entity.Product;
import com.att.shopping.product.repository.ProductRepository;
import com.att.shopping.product.service.ProductService;
import com.att.shopping.product.service.ProductServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ProductServiceMockTest {

    @Mock
    private ProductRepository productRepository;
    private ProductService productService;

    @BeforeEach
    public void setup() {

        MockitoAnnotations.initMocks( this );

        productService = new ProductServiceImpl( productRepository );

        Product computer = Product.builder()
                .id( 1L )
                .name( "Computer" )
                .category( Category.builder().id(1L).build() )
                .price( Double.parseDouble( "12.5") )
                .stock( Integer.parseInt( "5" ))
                .build();

        Mockito.when( productRepository.findById( 1L ) )
                .thenReturn( Optional.of(computer) );

        Mockito.when( productRepository.save( computer )).thenReturn( computer );

    }

    @Test
    public void whenValidGetID_ThenReturnProduct() {
        Product found = productService.getProduct( 1L );
        Assertions.assertThat( found.getName()).isEqualTo("Computer");

    }

    @Test
    public void whenValidUpdateStock_ThenReturnNewStock() {
        Product newStock = productService.updateStock(1L, Integer.parseInt("8"));
        Assertions.assertThat( newStock.getStock() ).isEqualTo( 13 );
    }

}
