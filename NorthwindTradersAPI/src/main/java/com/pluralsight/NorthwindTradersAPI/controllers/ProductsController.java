package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.dao.ProductDAO;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductsController {
    @Autowired
    ProductDAO productDAO;

    @RequestMapping(method = RequestMethod.GET, path = "/product/{id}")
    public Product getProductByID(
            @PathVariable int id
    ) {
        Optional<Product> productOptional = productDAO.findById(id);
        return productOptional.orElseGet(Product::new); //for now this works but maybe not kind
    }

    @RequestMapping(method = RequestMethod.GET, path = "/products")
    public List<Product> getProducts() {
        return Streamable.of(productDAO.findAll()).toList();
    }
}
