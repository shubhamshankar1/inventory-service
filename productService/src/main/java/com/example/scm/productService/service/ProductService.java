package com.example.scm.productService.service;


import com.example.scm.productService.entity.Product;
import com.example.scm.productService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return productRepository.saveAll(products);
    }
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public Product getProductById(int productId){
        return productRepository.findById(productId).orElse(null);
    }
    public Product getProductByName(String productName){
        return productRepository.findByName(productName);
    }
    public String deleteProduct(int productId){
        productRepository.deleteById(productId);
        return "product removed !!!"+productId;
    }
    public Product updateProduct(Product product){
        Product existingProduct=productRepository.findById(product.getProductId()).orElse(null);
        existingProduct.setProductName(product.getProductName());
        existingProduct.setProductType(product.getProductType());
        existingProduct.setProductQty(product.getProductQty());
        existingProduct.setProductCost(product.getProductCost());
        return productRepository.save(existingProduct);



    }


}
