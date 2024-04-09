package com.example.productservicesst.services;
import com.example.productservicesst.exceptions.CategoryNotFoundException;
import com.example.productservicesst.exceptions.ProductNotFoundException;
import com.example.productservicesst.models.Category;
import com.example.productservicesst.models.Product;
import com.example.productservicesst.repositories.CategoryRepository;
import org.springframework.stereotype.Service;
import com.example.productservicesst.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service("selfProductServices")
public class SelfProductServices implements ProductService{
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    SelfProductServices(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()) {
            throw new ProductNotFoundException(id, "Product not found");
        }
        return product.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        if (product.getCategory().getId() == null) {
            Category category = product.getCategory();
            Category savedCategory = categoryRepository.save(category);
            product.setCategory(savedCategory);
        }
        else{
            Optional<Category> category = categoryRepository.findById(product.getCategory().getId());
            if(category.isEmpty()){
                throw new CategoryNotFoundException(product.getCategory().getId(), "Category not found");
            }
            product.setCategory(category.get());
        }
        return productRepository.save(product);
    }
}