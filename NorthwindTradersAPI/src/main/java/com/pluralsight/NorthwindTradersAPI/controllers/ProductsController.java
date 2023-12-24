package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.dao.ProductDAO;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.POST, path = "/product/add")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Product addProduct(
            @RequestBody Product product
    ) {
        return new Product(
                1,
                product.getCategoryID(),
                product.getName(),
                product.getUnitPrice()
        );
    }
}
