package com.att.store.shopping.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

@Data
public class Product {
    private Long id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private String status;

    private Date createdAt;
    private Category category;

}
