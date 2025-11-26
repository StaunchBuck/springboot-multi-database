package com.multi.database.app.service;

import com.multi.database.app.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final JdbcTemplate jdbc;

    public Product getProductById(Long id) {
        return jdbc.queryForObject("SELECT * FROM product where id = ?", (rs, rowNum) -> {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setProductName(rs.getString("product_name"));
            product.setProductType(rs.getString("product_type"));
            product.setProductManufacturer(rs.getString("product_manufacturer"));
            return product;
        }, id);
    }

    public List<Product> getProducts() {
        return jdbc.query("SELECT * FROM product", (rs, rowNum) -> {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setProductName(rs.getString("product_name"));
            product.setProductType(rs.getString("product_type"));
            product.setProductManufacturer(rs.getString("product_manufacturer"));
            return product;
        });
    }
}
