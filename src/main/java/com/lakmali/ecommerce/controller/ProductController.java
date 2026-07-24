package com.lakmali.ecommerce.controller;


import com.lakmali.ecommerce.dto.request.ProductRequest;
import com.lakmali.ecommerce.dto.response.ProductResponse;
import com.lakmali.ecommerce.service.ProductService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {


    private final ProductService productService;


    @PostMapping
    public ProductResponse createProduct(
            @Valid @RequestBody ProductRequest request){

        return productService.createProduct(request);
    }


    @GetMapping
    public List<ProductResponse> getProducts(){

        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResponse getProduct(@PathVariable Long id) {

        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequest request) {

        return productService.updateProduct(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long id) {

        productService.deleteProduct(id);
    }

}