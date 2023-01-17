package com.example.fzco.controller;

import com.example.fzco.exception.FzcoException;
import com.example.fzco.model.Product;
import com.example.fzco.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fzco")
public class ProductHandler {
    @Autowired
    private ProductService productService;


    @PostMapping("/addProduct")
    public ResponseEntity<Product> saveProduct(@RequestBody Optional<Product> product) throws FzcoException {
        if (product.isPresent()){
            Product prd= productService.saveProduct(product.get());
            return new ResponseEntity<>(productService.saveProduct(prd), HttpStatus.CREATED);
        }
        else {
            throw new FzcoException("please fill the product");
        }

    }

    @GetMapping("/getProduct/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long productId) throws FzcoException {
        return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
    }

    @GetMapping("/allProduct")
    public List<Product> getAllProduct(){
        return productService.getAllProducts();
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<Product> updateProductId(@PathVariable("id") long productId,@RequestBody Product product ) throws FzcoException {
        return new ResponseEntity<>(productService.updateProduct(product, productId), HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<String> updateProductId(@PathVariable("id") long productId) throws FzcoException {
        productService.deleteProductById(productId);
        return new ResponseEntity<String>("deleted", HttpStatus.OK);
    }





}
