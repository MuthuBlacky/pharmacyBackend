package com.example.pharmacy.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productName;
    private String productDetails;
    private double productOriginalPrice;
    private String productType;
    private String productOffer;
    private String productImage;
    private Date productExpiryDate;
    private Date productManufactureDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Carousel carousel;

    // No-argument constructor
    public Product() {
    }

    // Constructor with arguments
    public Product(String productName, String productDetails, double productOriginalPrice, String productType,
                   String productOffer, String productImage, Date productExpiryDate, Date productManufactureDate) {
        this.productName = productName;
        this.productDetails = productDetails;
        this.productOriginalPrice = productOriginalPrice;
        this.productType = productType;
        this.productOffer = productOffer;
        this.productImage = productImage;
        this.productExpiryDate = productExpiryDate;
        this.productManufactureDate = productManufactureDate;
    }

    // Getters and setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public double getProductOriginalPrice() {
        return productOriginalPrice;
    }

    public void setProductOriginalPrice(double productOriginalPrice) {
        this.productOriginalPrice = productOriginalPrice;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductOffer() {
        return productOffer;
    }

    public void setProductOffer(String productOffer) {
        this.productOffer = productOffer;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Date getProductExpiryDate() {
        return productExpiryDate;
    }

    public void setProductExpiryDate(Date productExpiryDate) {
        this.productExpiryDate = productExpiryDate;
    }

    public Date getProductManufactureDate() {
        return productManufactureDate;
    }

    public void setProductManufactureDate(Date productManufactureDate) {
        this.productManufactureDate = productManufactureDate;
    }

    public Carousel getCarousel() {
        return carousel;
    }

    public void setCarousel(Carousel carousel) {
        this.carousel = carousel;
    }
}
