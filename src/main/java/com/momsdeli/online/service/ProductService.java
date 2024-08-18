package com.momsdeli.online.service;

import com.momsdeli.online.dto.ProductDTO;
import com.momsdeli.online.mapper.ProductMapper;
import com.momsdeli.online.model.Product;
import com.momsdeli.online.repository.ProductRepository;
import com.momsdeli.online.request.ProductRequest;
import com.momsdeli.online.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public ProductResponse addProduct(ProductRequest request) {
        Product product = productMapper.requestToProduct(request);
        product = productRepository.save(product);
        return productMapper.productToResponse(product);
    }

    public ProductResponse updateProduct(Long id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productMapper.updateProductFromDTO(request, product);
        product = productRepository.save(product);
        return productMapper.productToResponse(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return productMapper.productToResponse(product);
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::productToResponse)
                .collect(Collectors.toList());
    }
}
