package com.inmemory.authentication.sample.service;

import com.inmemory.authentication.sample.entity.Product;
import com.inmemory.authentication.sample.exception.ProductNotFoundException;
import com.inmemory.authentication.sample.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id + " product not found!"));
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        Product updateProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id + " product not found!"));

        updateProduct.setName(product.getName());
        updateProduct.setPrice(product.getPrice());
        return productRepository.save(updateProduct);
    }

    @Override
    public void delete(Long id) {
        Product deletedProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id + " product not found!"));
        productRepository.delete(deletedProduct);
    }
}
