package com.example.exercisejpa.Service;

import com.example.exercisejpa.Model.Product;
import com.example.exercisejpa.Repository.ProductRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public boolean updateProduct(Integer id , Product product) {
        Product p = productRepository.getById(id);
        if(p==null) {
            return false;
        }
        p.setName(product.getName());
        p.setCategoryId(product.getCategoryId());
        p.setPrice(product.getPrice());
        productRepository.save(p);
        return true;
    }
    public boolean deleteProduct(Integer id) {
        Product p = productRepository.getById(id);
        if(p==null) {
            return false;
        }
        productRepository.delete(p);
        return true;
    }

}
