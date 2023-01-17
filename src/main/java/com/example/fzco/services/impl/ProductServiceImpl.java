package com.example.fzco.services.impl;

import com.example.fzco.exception.FzcoException;
import com.example.fzco.model.Product;
import com.example.fzco.repository.ProductRepo;
import com.example.fzco.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {

   @Autowired
    private ProductRepo productRepo;

    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product getProductById(long id) throws FzcoException {
        return productRepo.findById(id).orElseThrow(()->new FzcoException("product not found"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Product updateProduct(Product product, long id) throws FzcoException {
        Product oldProduct = productRepo.findById(id).orElseThrow(()->new FzcoException("product not found"));
        oldProduct.setName(product.getName());
        oldProduct.setPrice(product.getPrice());

        productRepo.save(oldProduct);

        return oldProduct;
    }

    @Override
    public void deleteProductById(long id) throws FzcoException {
       Product product= productRepo.findById(id).orElseThrow(()->new FzcoException("product not found"));
       productRepo.deleteById(product.getId());

    }

}
