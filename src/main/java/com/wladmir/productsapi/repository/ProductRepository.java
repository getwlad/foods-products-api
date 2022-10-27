package com.wladmir.productsapi.repository;


import com.wladmir.productsapi.controller.ProductController;
import com.wladmir.productsapi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;


@Repository
public interface ProductRepository  extends CrudRepository<Product, Long> {



}
