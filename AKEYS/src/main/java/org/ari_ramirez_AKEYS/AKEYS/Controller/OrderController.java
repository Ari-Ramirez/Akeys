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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
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
    public ResponseEntity<String> checkout(@RequestBody List<Products> selectedProducts) {
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
            orderItem.setQuantity(1); // Assuming quantity is 1, adjust as needed
            orderItemRepository.save(orderItem);
        }

        // Add your logic to generate order number, update inventory, etc.

        // Return a success message or order ID
        return ResponseEntity.ok("Checkout successful! Redirecting to the account page.");
    }

    private User getCurrentUser() {
        // Implement your logic to get the currently logged-in user
        // For simplicity, you can replace this with your authentication logic
        // For example:
        // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // String username = authentication.getName();
        // User user = userRepository.findByUsername(username);
        // return user;
        return null;
    }
}