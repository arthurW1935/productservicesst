package com.example.productservicesst.services;

import com.example.productservicesst.exceptions.ProductNotFoundException;
import com.example.productservicesst.models.Product;
import com.example.productservicesst.models.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.productservicesst.dtos.FakeStoreProductDto;
import java.util.List;
import java.util.ArrayList;

@Service
public class FakeStoreProductService implements ProductService{
    @Override
    public Product getProductById(Long id) {
        RestTemplate restTemplate = new RestTemplate();

        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                        FakeStoreProductDto.class);

        if(fakeStoreProductDto == null)
            throw new ProductNotFoundException(id, "Product not found");

        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto[] fakeStoreProductDtos =
                restTemplate.getForObject("https://fakestoreapi.com/products",
                        FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }
        return products;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        product.setPrice(fakeStoreProductDto.getPrice());


        return product;
    }

}
