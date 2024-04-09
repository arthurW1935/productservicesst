package com.example.productservicesst.exceptions;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryNotFoundException extends RuntimeException{
    private Long id;
    public CategoryNotFoundException(Long id, String message) {
        super(message);
        this.id = id;
    }
}
