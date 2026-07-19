package com.app.ecom.mapper;

import com.app.ecom.dto.ProductRequest;
import com.app.ecom.dto.ProductResponse;
import com.app.ecom.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductResponse mapToProductResponse(Product product){
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setStockQuantity(product.getStockQuantity());
        response.setCategory(product.getCategory());
        response.setImageUrl(product.getImageUrl());
        response.setActive(product.isActive());
        return response;
    }

    public void updateProductFromRequest(Product product, ProductRequest productRequest) {
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setStockQuantity(productRequest.getStockQuantity());
        product.setCategory(productRequest.getCategory());
        product.setImageUrl(productRequest.getImageUrl());
    }
}
