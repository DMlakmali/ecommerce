package com.lakmali.ecommerce.service;


import com.lakmali.ecommerce.dto.request.ProductRequest;
import com.lakmali.ecommerce.dto.response.ProductResponse;

import java.util.List;


public interface ProductService {

    ProductResponse createProduct(ProductRequest request);

    List<ProductResponse> getAllProducts();
    ProductResponse getProductById(Long id);

    ProductResponse updateProduct(Long id, ProductRequest request);

    void deleteProduct(Long id);

}