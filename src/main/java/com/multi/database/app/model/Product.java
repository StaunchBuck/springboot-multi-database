package com.multi.database.app.model;

import lombok.Data;

@Data
public class Product {
    private long id;
    private String productName;
    private String productType;
    private String productManufacturer;
}
