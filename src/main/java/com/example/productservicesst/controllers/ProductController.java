package com.example.productservicesst.controllers;

import java.util.List;
import com.example.productservicesst.models.Product;
import com.example.productservicesst.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        System.out.println("ProductController.getProductById");
        return productService.getProductById(id);
    }

    @GetMapping("")
    public List<Product> getAllProducts() {
        System.out.println("ProductController.getProductById");
        return productService.getAllProducts();
    }

}
