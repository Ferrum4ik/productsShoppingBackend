package com.example.productsShopping.repository;

import com.example.productsShopping.model.Product;
import com.example.productsShopping.model.User;
import com.example.productsShopping.repository.ProductRepository;
import com.example.productsShopping.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) {
        if (productRepository.count() == 0) {
            User user = createUser("Timur", "Mamedov", "Timur@example.com", "Timur", "Timur");
            userRepository.save(user);
            List<Product> products = Arrays.asList(
                    createProduct("Samsung", "Samsung Galaxy S21", "Smartphones", "Latest Samsung Galaxy smartphone", 799.99, 5, "https://example.com/smartphones.jpg", user),
                    createProduct("Apple", "Apple iPhone 13", "Smartphones", "Newest Apple iPhone model", 999.99, 5, "https://example.com/smartphones.jpg", user),
                    createProduct("Apple", "Apple MacBook Pro", "Laptops", "Powerful Apple laptop", 1299.99, 5, "https://example.com/laptop1.jpg", user),
                    createProduct("Dell", "Dell XPS 13", "Laptops", "High-performance Dell laptop", 1199.99, 5, "https://example.com/laptop2.jpg", user),
                    createProduct("Microsoft", "Microsoft Xbox Controller", "Gaming Accessories", "Ergonomic Xbox game controller", 59.99, 4, "https://example.com/gaming.jpg", user),
                    createProduct("Sony", "Sony PS5 Controller", "Gaming Accessories", "Sony DualSense wireless controller", 69.99, 4, "https://example.com/gaming.jpg", user),
                    createProduct("Samsung", "Samsung QLED TV", "Electronics", "4K UHD Smart TV", 1499.99, 5, "https://example.com/tv1.jpg", user),
                    createProduct("LG", "LG OLED TV", "Electronics", "Premium OLED TV with AI", 1999.99, 5, "https://example.com/tv2.jpg", user),
                    createProduct("Sony", "Sony WH-1000XM4", "Audio", "Noise-cancelling wireless headphones", 349.99, 5, "https://example.com/headphones.jpg", user),
                    createProduct("Bose", "Bose QC45", "Audio", "Premium noise-cancelling headphones", 329.99, 5, "https://example.com/headphones.jpg", user),
                    createProduct("Apple", "Apple Watch Series 7", "Wearables", "Smartwatch with health features", 399.99, 5, "https://example.com/watch1.jpg", user),
                    createProduct("Samsung", "Samsung Galaxy Watch 4", "Wearables", "Smartwatch with fitness tracking", 299.99, 5, "https://example.com/watch2.jpg", user),
                    createProduct("Hanes", "Hanes Cotton T-Shirt", "Clothing", "Comfortable cotton t-shirt", 19.99, 4, "https://example.com/shirt1.jpg", user),
                    createProduct("Calvin Klein", "Calvin Klein Formal Shirt", "Clothing", "Elegant formal shirt", 39.99, 4, "https://example.com/shirt2.jpg", user),
                    createProduct("Nike", "Nike Running Shoes", "Footwear", "Lightweight running shoes", 89.99, 5, "https://example.com/shoes.jpg", user),
                    createProduct("Timberland", "Timberland Leather Boots", "Footwear", "Stylish leather boots", 149.99, 4, "https://example.com/boots.jpg", user),
                    createProduct("Samsonite", "Samsonite Backpack", "Accessories", "Durable and spacious backpack", 79.99, 5, "https://example.com/bag1.jpg", user),
                    createProduct("Michael Kors", "Michael Kors Handbag", "Accessories", "Elegant leather handbag", 199.99, 5, "https://example.com/bag2.jpg", user),
                    createProduct("Apple", "Apple iPad Pro", "Tablets", "Powerful Apple tablet", 899.99, 5, "https://example.com/tablet1.jpg", user),
                    createProduct("Samsung", "Samsung Galaxy Tab S7", "Tablets", "High-performance Android tablet", 699.99, 5, "https://example.com/tablet2.jpg", user)
            );

            productRepository.saveAll(products);

            System.out.println("База данных успешно заполнена начальными данными.");
        } else {
            System.out.println("База данных уже содержит данные. Инициализация пропущена.");
        }
    }

    private User createUser(String firstName, String lastName, String email, String username, String password) {
        User user = new User();
        user.setName(firstName);
        user.setSurname(lastName);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }

    private Product createProduct(String brand, String model, String category, String description, double price, int rate, String imageUrl, User user) {
        Product product = new Product();
        product.setBrand(brand);
        product.setModel(model);
        product.setCategory(category);
        product.setDescription(description);
        product.setPrice(price);
        product.setRate(rate);
        product.setImageUrl(imageUrl);
        product.setUser(user);
        return product;
    }
}