package com.wladmir.productsapi.service;

import com.wladmir.productsapi.handler.BusinessException;
import com.wladmir.productsapi.model.Category;
import com.wladmir.productsapi.model.Product;
import com.wladmir.productsapi.repository.CategoryRepository;
import com.wladmir.productsapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private CategoryRepository categoryRepository;

    public Iterable<Product> getProducts() {
        return repository.findAll();
    }

    public Product addProduct(Product product) {
        try {
            repository.save(product);
            return product;
        } catch (Exception ex) {
            throw new BusinessException("Ocorreu um erro, por favor tente novamente", HttpStatus.BAD_REQUEST);
        }
    }

    public Product getProductById(Long id) {
        if (id == null) throw new BusinessException("Por favor insira corretamente o id", HttpStatus.BAD_REQUEST);
        Optional<Product> optProduct = repository.findById(id);
        if (optProduct.isEmpty()) throw new BusinessException("Produto não encontrado", HttpStatus.NOT_FOUND);
        Product product = optProduct.get();
        return product;
    }

    public Product updateProduct(Long idProduct, Product updatedProduct) {
        updatedProduct.setId(idProduct);
        getProductById(idProduct);
        try {
            repository.save(updatedProduct);
            return updatedProduct;
        } catch (Exception ex) {
            throw new BusinessException("Ocorreu um erro, por favor tente novamente", HttpStatus.BAD_REQUEST);
        }

    }

    public Product deleteProduct(Long id) {
        Product product = getProductById(id);
        try {
            repository.delete(product);
            return product;
        } catch (Exception ex) {
            throw new BusinessException("Ocorreu um erro, por favor tente novamente", HttpStatus.BAD_REQUEST);
        }
    }

    public Product setProductCategory(Long idProduct, Long categoryId) {
        if (idProduct == null || categoryId == null)
            throw new BusinessException("Por favor insira corretamente os id's", HttpStatus.BAD_REQUEST);

        Product product = getProductById(idProduct);

        Optional<Category> optCategory = categoryRepository.findById(categoryId);
        if (optCategory.isEmpty()) throw new BusinessException("Categoria não encontrada", HttpStatus.NOT_FOUND);
        ;

        Category category = optCategory.get();
        try {
            product.setCategory(category);
            repository.save(product);
            return product;
        } catch (Exception ex) {
            throw new BusinessException("Ocorreu um erro, por favor tente novamente", HttpStatus.BAD_REQUEST);
        }
    }


}
