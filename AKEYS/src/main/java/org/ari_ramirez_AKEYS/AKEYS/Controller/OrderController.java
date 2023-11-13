package org.ari_ramirez_AKEYS.AKEYS.Controller;

import org.ari_ramirez_AKEYS.AKEYS.Entity.OrderItem;
import org.ari_ramirez_AKEYS.AKEYS.Entity.Orders;
import org.ari_ramirez_AKEYS.AKEYS.Entity.Products;
import org.ari_ramirez_AKEYS.AKEYS.Entity.User;
import org.ari_ramirez_AKEYS.AKEYS.Repository.OrderItemRepository;
import org.ari_ramirez_AKEYS.AKEYS.Repository.OrdersRepository;
import org.ari_ramirez_AKEYS.AKEYS.Repository.ProductsRepository;
import org.ari_ramirez_AKEYS.AKEYS.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    private OrdersRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @PostMapping("/checkout")
    public ResponseEntity<Map<String, Object>> checkout(@RequestBody List<Products> selectedProducts) {
        // Assuming you have a method to get the currently logged-in user
        User currentUser = getCurrentUser();

        // Create a new order for the current user
        Orders order = new Orders();
        order.setUser(currentUser);
        orderRepository.save(order);

        // Add selected products to the order as order items
        for (Products product : selectedProducts) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItem.setQuantity(product.getQuantity()); // Assuming quantity is 1, adjust as needed
            orderItemRepository.save(orderItem);
        }

        // Log success and return a success message or order ID
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Checkout successful! Redirecting to the account page.");

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    private User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof User) {
            return (User) authentication.getPrincipal();
        }
        return null;
    }

    private int getProductQuantity(Products product) {
        return 1;
    }
}