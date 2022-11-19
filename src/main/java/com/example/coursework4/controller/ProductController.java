package com.example.coursework4.controller;

import com.example.coursework4.model.Product;
import com.example.coursework4.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/api/product")
public class ProductController {

    @GetMapping
    @ResponseBody()
    public User getProduct(@PathParam("id") Integer id){

        return new User();
    }
}
