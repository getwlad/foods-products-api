package com.wladmir.productsapi.repository;

import com.wladmir.productsapi.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
