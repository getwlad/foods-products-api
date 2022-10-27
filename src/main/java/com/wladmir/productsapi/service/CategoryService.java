package com.wladmir.productsapi.service;

import com.wladmir.productsapi.handler.BusinessException;
import com.wladmir.productsapi.model.Category;
import com.wladmir.productsapi.model.Product;
import com.wladmir.productsapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public Iterable<Category> getCategories(){
        return repository.findAll();
    }

    public Category getCategoryById(Long id){
        if(id == null) throw new BusinessException("Por favor insira corretamente o id", HttpStatus.BAD_REQUEST);
        Optional<Category> optCategory = repository.findById(id);
        if(optCategory.isEmpty()) throw new BusinessException("Categoria não encontrada", HttpStatus.NOT_FOUND);
        Category category = optCategory.get();
        return category;
    }

    public Category createCategory(Category category){
        try {
            repository.save(category);
            return category;
        }
        catch (Exception ex){
            throw new BusinessException("Ocorreu um erro, por favor tente novamente", HttpStatus.BAD_REQUEST);
        }
    }
    public Category updateCategory(Long id, Category updatedCategory){
            updatedCategory.setId(id);
            getCategoryById(id);
        try {
            repository.save(updatedCategory);
            return updatedCategory;
        }
        catch (Exception ex){
            throw new BusinessException("Ocorreu um erro, por favor tente novamente", HttpStatus.BAD_REQUEST);
        }
    }
    public Category deleteCategory(Long id){
        Category category = getCategoryById(id);
        try {
            repository.delete(category);
            return category;
        }
        catch (Exception ex){
            throw new BusinessException("Ocorreu um erro, por favor tente novamente", HttpStatus.BAD_REQUEST);
        }
    }
}
