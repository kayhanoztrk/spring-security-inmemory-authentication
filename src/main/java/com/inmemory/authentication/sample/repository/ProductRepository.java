package com.inmemory.authentication.sample.repository;

import com.inmemory.authentication.sample.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
        List<Product> findByName(String name);
        List<Product> findByPrice(String price);
}
