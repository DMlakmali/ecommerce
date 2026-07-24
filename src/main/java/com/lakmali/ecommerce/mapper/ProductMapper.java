package com.lakmali.ecommerce.mapper;

import com.lakmali.ecommerce.dto.request.ProductRequest;
import com.lakmali.ecommerce.dto.response.ProductResponse;
import com.lakmali.ecommerce.entity.Product;
import org.springframework.stereotype.Component;


@Component
public class ProductMapper {


    public Product toEntity(ProductRequest request){

        return Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .stock(request.getStock())
                .imageUrl(request.getImageUrl())
                .category(request.getCategory())
                .build();

    }


    public ProductResponse toResponse(Product product){

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .imageUrl(product.getImageUrl())
                .category(product.getCategory())
                .active(product.getActive())
                .build();

    }
}