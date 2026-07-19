package com.app.ecom.service;

import com.app.ecom.dto.ProductRequest;
import com.app.ecom.dto.ProductResponse;
import com.app.ecom.mapper.ProductMapper;
import com.app.ecom.model.Product;
import com.app.ecom.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = new Product();
        productMapper.updateProductFromRequest(product, productRequest);
        return productMapper.mapToProductResponse(productRepository.save(product));
    }

    public Optional<ProductResponse> updateProduct(Long id, ProductRequest productRequest) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    productMapper.updateProductFromRequest(existingProduct, productRequest);
                    Product savedProduct = productRepository.save(existingProduct);
                    return productMapper.mapToProductResponse(savedProduct);
                });
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findByIsActiveTrue().stream()
                .map(productMapper::mapToProductResponse)
                .toList();
    }

    public boolean deleteProduct(Long id) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setActive(false);
                    productRepository.save(product);
                    return true;
                }).orElse(false);
    }
}
