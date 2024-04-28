package com.example.pharmacy.Service;




import com.example.pharmacy.Entity.Carousel;
import com.example.pharmacy.Entity.Product;
import com.example.pharmacy.Repository.CarouselRepository;
import com.example.pharmacy.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselRepository carouselRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Carousel addCarousel(Carousel carousel) {
        Carousel savedCarousel = carouselRepository.save(carousel);
        // Update related products if any
        for (Product product : carousel.getSubProducts()) {
            product.setCarousel(savedCarousel);
            productRepository.save(product);
        }
        return savedCarousel;
    }
}
