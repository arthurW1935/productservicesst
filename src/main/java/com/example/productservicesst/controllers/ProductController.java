package com.example.productservicesst.controllers;

import java.util.List;
import com.example.productservicesst.models.Product;
import com.example.productservicesst.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    ProductController(@Qualifier("selfProductServices") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

}
