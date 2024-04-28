package com.example.pharmacy.Controller;

import com.example.pharmacy.Entity.Product;
import com.example.pharmacy.Repository.ProductRepository;
import com.example.pharmacy.Repository.CarouselRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CarouselRepository carouselRepository;

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        Product savedProduct = productRepository.save(product);
        // Update related carousel if any
        // For simplicity, assuming only one carousel per product
        if (product.getCarousel() != null) {
            product.getCarousel().getSubProducts().add(savedProduct);
            carouselRepository.save(product.getCarousel());
        }
        return savedProduct;
    }

    // Add other CRUD operations as needed
}
