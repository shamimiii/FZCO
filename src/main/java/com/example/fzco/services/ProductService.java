package com.example.fzco.services;

import com.example.fzco.exception.FzcoException;
import com.example.fzco.model.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    Product getProductById(long id) throws FzcoException;

    List<Product> getAllProducts();

    Product updateProduct(Product product,long id) throws FzcoException;

    void deleteProductById(long id) throws FzcoException;

}
