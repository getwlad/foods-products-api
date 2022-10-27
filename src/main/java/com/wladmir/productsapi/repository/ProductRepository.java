package com.wladmir.productsapi.repository;


import com.wladmir.productsapi.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProductRepository  extends CrudRepository<Product, Long> {



}
