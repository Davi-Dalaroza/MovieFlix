package br.com.movieflix.service;

import br.com.movieflix.entity.Category;
import br.com.movieflix.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }

    public Optional<Category> findById(Long id){
        return categoryRepository.findById(id);
    }

    public Optional<Category> updateCategory(Long id, Category category){
        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if(optionalCategory.isPresent()){
            Category categoryUpdate = optionalCategory.get();
            categoryUpdate.setName(category.getName());

            categoryRepository.save(categoryUpdate);
            return Optional.of(categoryUpdate);
        }
        return Optional.empty();
    }

    public void deleteCategoryById(Long id){
        categoryRepository.deleteById(id);
    }


}
