package com.ehome.services;

import com.ehome.entities.Order;
import com.ehome.entities.Product;
import com.ehome.entities.User;
import com.ehome.payload.OrderDto;
import com.ehome.repository.OrderRepository;
import com.ehome.repository.ProductRepository;
import com.ehome.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private UserRepository userrepository;

    @Autowired
    private ProductRepository productrepository;

    @Autowired
    private ModelMapper modelmapper;

    @Autowired
    private ObjectMapper objectMapper;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Integer id) {
        Optional<Order> order = repository.findById(id);
        return order.orElse(null);
    }

    public OrderDto createOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setFullName(orderDto.getFullName());
        order.setAddress(orderDto.getAddress());
        order.setCity(orderDto.getCity());
        order.setCountry(orderDto.getCountry());
        order.setPostalCode(orderDto.getPostalCode());
   

        // ✅ Fetch User
        User user = userrepository.findById(orderDto.getUserId())
            .orElseThrow(() -> new RuntimeException("User not found with ID: " + orderDto.getUserId()));
        order.setUser(user);

        // ✅ Fetch Products
        List<Product> products = orderDto.getProductIds().stream()
            .map(productId -> productrepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId)))
            .collect(Collectors.toList());
        order.setProducts(products);

        // ✅ Save Order with User and Products
        Order savedOrder = repository.save(order);

        // ✅ Convert to DTO for response
        OrderDto responseDto = new OrderDto();
        responseDto.setFullName(savedOrder.getFullName());
        responseDto.setAddress(savedOrder.getAddress());
        responseDto.setCity(savedOrder.getCity());
        responseDto.setCountry(savedOrder.getCountry());
        responseDto.setPostalCode(savedOrder.getPostalCode());
        responseDto.setUserId(savedOrder.getUser().getId());  
        responseDto.setProductIds(savedOrder.getProducts().stream()
            .map(Product::getId)
            .collect(Collectors.toList()));

        return responseDto;
    }


    public OrderDto getOrderById(Integer orderId) {
        Order order = repository.findById(orderId)
            .orElseThrow(() -> new RuntimeException("Order not found"));

        List<Long> productIds = order.getProducts().stream()
            .map(Product::getId)
            .collect(Collectors.toList());

        OrderDto response = new OrderDto();
        response.setFullName(order.getFullName());
        response.setAddress(order.getAddress());
        response.setCity(order.getCity());
        response.setPostalCode(order.getPostalCode());
        response.setCountry(order.getCountry());
        response.setProductIds(productIds);

        return response;
    }

}