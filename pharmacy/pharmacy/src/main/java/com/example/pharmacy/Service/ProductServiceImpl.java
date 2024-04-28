package com.example.pharmacy.Service;



import com.example.pharmacy.Entity.Carousel;
import com.example.pharmacy.Entity.Product;
import com.example.pharmacy.Repository.ProductRepository;
import com.example.pharmacy.Repository.CarouselRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CarouselRepository carouselRepository;

    @Override
    public Product addProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        // Update related carousel if any
        if (product.getCarousel() != null) {
            Carousel carousel = product.getCarousel();
            carousel.getSubProducts().add(savedProduct);
            carouselRepository.save(carousel);
        }
        return savedProduct;
    }
}
