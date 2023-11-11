package org.ari_ramirez_AKEYS.AKEYS.Service;

import org.ari_ramirez_AKEYS.AKEYS.Entity.Products;
import org.ari_ramirez_AKEYS.AKEYS.Repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {
    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsServiceImpl(ProductsRepository productRepository) {
        this.productsRepository = productRepository;
    }

    @Override
    public List<Products> getAllProducts() {
        // Assuming you have a method in ProductRepository to get all products
        return (List<Products>) productsRepository.findAll();
    }
}
