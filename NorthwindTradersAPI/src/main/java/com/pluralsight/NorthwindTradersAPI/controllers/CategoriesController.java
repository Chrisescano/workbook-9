package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.dao.CategoriesDAO;
import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoriesController {
    @Autowired
    CategoriesDAO categoriesDAO;

    @RequestMapping(method = RequestMethod.GET, path = "/category/{id}")
    public Category getCategoryByID(
            @PathVariable int id
    ) {
        Optional<Category> productOptional = categoriesDAO.findById(id);
        return productOptional.orElseGet(Category::new); //for now this works but maybe not kind
    }

    @RequestMapping(method = RequestMethod.GET, path = "/categories")
    public List<Category> getCategories() {
        return Streamable.of(categoriesDAO.findAll()).toList();
    }
}
