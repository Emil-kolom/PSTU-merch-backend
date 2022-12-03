package com.example.coursework4.service;

import com.example.coursework4.DTO.OrderPlacementDto;
import com.example.coursework4.model.Client;
import com.example.coursework4.model.Order;
import com.example.coursework4.model.OrderDetails;
import com.example.coursework4.model.Product;
import com.example.coursework4.repository.ClientRepository;
import com.example.coursework4.repository.OrderRepository;
import com.example.coursework4.repository.ProductRepository;
import com.example.coursework4.repository.WarehouseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;
    private final WarehouseRepository warehouseRepository;

    public OrderService(OrderRepository orderRepository, ClientRepository clientRepository, ProductRepository productRepository, WarehouseRepository warehouseRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
        this.warehouseRepository = warehouseRepository;
    }

    public Optional<Order> placeOrder(OrderPlacementDto orderPlacementDto) throws ResponseStatusException {
        Client client = clientRepository
                .findByFirstNameAndPhoneNumber(
                        orderPlacementDto.getFirstName(),
                        orderPlacementDto.getPhoneNumber())
                .orElse(new Client(
                        orderPlacementDto.getFirstName(),
                        orderPlacementDto.getSecondName(),
                        orderPlacementDto.getMiddleName(),
                        orderPlacementDto.getPhoneNumber()
                ));

        Order order = new Order();
        order.setClient(client);
        order.setAddress(orderPlacementDto.getAddress());
        order.setNote(orderPlacementDto.getNote());
        order.setEmail(orderPlacementDto.getEmail());

        List<OrderDetails> productList = new ArrayList<>();
        for (var productInfo : orderPlacementDto.getProductInOrderList()) {
            Product product = productRepository.findById(productInfo.getId()).orElseThrow(()-> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "product not found"
            ));
            productList.add(
                    new OrderDetails(product,
                            order,
                            productInfo.getSize(),
                            productInfo.getQuantity(),
                            warehouseRepository.findByProductAndSize(product,
                                    productInfo.getSize()).getPrice()));
        }
        order.setOrderDetailsList(productList);

        orderRepository.save(order);
        return Optional.of(order);
    }
}
