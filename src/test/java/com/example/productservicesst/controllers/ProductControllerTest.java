package com.example.productservicesst.controllers;


import com.example.productservicesst.models.Category;
import com.example.productservicesst.models.Product;
import com.example.productservicesst.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {
    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;
    @Test
    void getProductById() {

        Product product = new Product(101L, "moto edge 20", "", 23.0 , new Category(1L, "Category 1 phone", "it's a phone"), "www.img.com");

        when(productService.getProductById(101L)).thenReturn(product);

        Product resultant = productController.getProductById(101L);

        assertEquals(product, resultant);

    }

    @Test
    void getAllProducts() {

        List<Product> products = List.of(new Product(102L, "Product 1", "", 23.0,new Category(1L, "Category 1", "description of product") , ""));

        when(productService.getAllProducts()).thenReturn(products);

        List<Product> products1 = productController.getAllProducts();

        assertEquals(products, products1);

    }

    @Test
    void createProduct() {

    }
}
