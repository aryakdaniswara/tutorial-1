package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("")
public class HomePageController {

    @Autowired
    private ProductService service;

    @GetMapping("")
    public String HomePage(){
        return "HomePage";
    }

}