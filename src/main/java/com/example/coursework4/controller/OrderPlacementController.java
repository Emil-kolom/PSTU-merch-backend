package com.example.coursework4.controller;

import com.example.coursework4.DTO.OrderPlacementDto;
import com.example.coursework4.model.ErrorResponseObject;
import com.example.coursework4.model.Order;
import com.example.coursework4.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/order-placement")
public class OrderPlacementController
{

    private final OrderService orderService;

    public OrderPlacementController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public OrderPlacementDto getOrders(){

        return new OrderPlacementDto("","","","",
                false,false,"","","","",new ArrayList<>());
    }

    @PostMapping
    public ResponseEntity<String> placementNewOrder(@RequestBody OrderPlacementDto orderPlacementDto){
        orderService.placeOrder(orderPlacementDto);
        return new ResponseEntity<>("Successful order placement", HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponseObject> errorResponse(ResponseStatusException e) {

        return new ResponseEntity<>(new ErrorResponseObject(e.getReason()), e.getStatus());
    }
}
