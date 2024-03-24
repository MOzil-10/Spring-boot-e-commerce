package ecommerce.sports.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.sports.model.SportProducts;
import ecommerce.sports.services.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductsService productService;

    public ProductController(ProductsService productService) {
        
        this.productService = productService;
    }

    @GetMapping("/list")
    public List<SportProducts> getList(){

        return productService.getProducts();
     
    }

    @PostMapping("/addProduct")
    public SportProducts addProduct(@RequestBody SportProducts products ){

        return productService.saveProducts(products);
    }
}
