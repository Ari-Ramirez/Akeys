package org.ari_ramirez_AKEYS.AKEYS.ServiceTest;

import org.ari_ramirez_AKEYS.AKEYS.Entity.Products;
import org.ari_ramirez_AKEYS.AKEYS.Repository.ProductsRepository;
import org.ari_ramirez_AKEYS.AKEYS.Service.ProductsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;



@SpringBootTest
public class ProductsServiceTest {
    @Autowired
    private ProductsService productsService;

    @Autowired
    private ProductsRepository productsRepository;

    @Test
    public void testGetAllProducts() {

        Products product1 = new Products("Product1", 10.0);
        Products product2 = new Products("Product2", 20.0);
        productsRepository.save(product1);
        productsRepository.save(product2);


        List<Products> products = productsService.getAllProducts();


        assertEquals(2, products.size());

    }



}

