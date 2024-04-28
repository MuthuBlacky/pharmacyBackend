package com.example.pharmacy.Controller;

import com.example.pharmacy.Entity.Carousel;
import com.example.pharmacy.Entity.Product;
import com.example.pharmacy.Repository.CarouselRepository;
import com.example.pharmacy.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/carousels")
public class CarouselController {

    @Autowired
    private CarouselRepository carouselRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/add")
    public Carousel addCarousel(@RequestBody Carousel carousel) {
        Carousel savedCarousel = carouselRepository.save(carousel);
        // Update related products if any
        List<Product> subProducts = carousel.getSubProducts();
        if (subProducts != null) {
            for (Product product : subProducts) {
                product.setCarousel(savedCarousel);
                productRepository.save(product);
            }
        }
        return savedCarousel;
    }

    // Add other CRUD operations as needed
}
