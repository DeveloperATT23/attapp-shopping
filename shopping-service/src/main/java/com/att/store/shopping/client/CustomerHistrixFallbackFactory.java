package com.att.store.shopping.client;

import com.att.store.shopping.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerHistrixFallbackFactory implements CustomerClient{
    @Override
    public ResponseEntity<Customer> getCustomer( long id ) {
        Customer customer = Customer.builder()
                .firstName("none")
                .lastName("none")
                .email("none")
                .photoUrl("").build();
            return ResponseEntity.ok( customer );
    }
}
