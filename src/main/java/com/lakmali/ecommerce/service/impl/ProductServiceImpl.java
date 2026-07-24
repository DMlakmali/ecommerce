package com.lakmali.ecommerce.service.impl;


import com.lakmali.ecommerce.dto.request.ProductRequest;
import com.lakmali.ecommerce.dto.response.ProductResponse;
import com.lakmali.ecommerce.entity.Product;
import com.lakmali.ecommerce.exception.ProductNotFoundException;
import com.lakmali.ecommerce.mapper.ProductMapper;
import com.lakmali.ecommerce.repository.ProductRepository;
import com.lakmali.ecommerce.service.ProductService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    private final ProductMapper productMapper;


    @Override
    public ProductResponse createProduct(ProductRequest request) {

        Product product = productMapper.toEntity(request);

        Product savedProduct =
                productRepository.save(product);

        return productMapper.toResponse(savedProduct);
    }


    @Override
    public List<ProductResponse> getAllProducts() {

        return productRepository.findAll()
                .stream()
                .map(productMapper::toResponse)
                .toList();

    }

    @Override
    public ProductResponse getProductById(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        return productMapper.toResponse(product);
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest request) {
        Product product = productMapper.toEntity(request);

        Product updatedProduct =
                productRepository.findById(id)
                        .map(existingProduct -> {
                            existingProduct.setName(product.getName());
                            existingProduct.setDescription(product.getDescription());
                            existingProduct.setPrice(product.getPrice());
                            existingProduct.setStock(product.getStock());
                            existingProduct.setImageUrl(product.getImageUrl());
                            existingProduct.setCategory(product.getCategory());
                            return productRepository.save(existingProduct);
                        })
                        .orElseThrow(() -> new ProductNotFoundException(id));

        return productMapper.toResponse(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        productRepository.delete(product);
    }
}
