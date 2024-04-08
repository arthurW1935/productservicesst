package com.example.productservicesst.services;

import java.util.List;
import com.example.productservicesst.models.Product;

public interface ProductService {
    Product getProductById(Long id);

    List<Product> getAllProducts();
}
