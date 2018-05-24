/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.controller;

import hello.domain.Product;
import hello.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Ecyola
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping({"/list", "/"})
    public String listProducts(Model model) {

        model.addAttribute("products", productService.listAll());

        return "products/product-list";
    }

    @RequestMapping("/{id}")
    public String getProduct(@PathVariable Integer id, Model model) {

        model.addAttribute("product", productService.getById(id));

        return "products/product";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {

        model.addAttribute("product", productService.getById(id));

        return "products/product-form";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {

        productService.delete(id);

        return "redirect:/product/list";
    }

    @RequestMapping("/new")
    public String newProduct(Model model) {

        model.addAttribute("product", new Product());

        return "products/product-form";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String saveOrUpdateProduct(Product product) {
        Product savedProduct = productService.saveOrUpdate(product);
        return "redirect:/product/" + savedProduct.getId();
    }
}
