package ru.andreeva.shop.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.andreeva.shop.service.dao.Category;
import ru.andreeva.shop.service.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryRepository repository;

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> get(@PathVariable("id") int id) {
        return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Category> add(@RequestBody Category category) {
        return ResponseEntity.ok(repository.save(category));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable("id") int id, @RequestBody Category category) {
        if (id != category.getId() || repository.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(repository.save(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> delete(@PathVariable("id") int id) {
        Optional<Category> category = repository.findById(id);
        if (category.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        repository.deleteById(id);
        return ResponseEntity.ok(category.get());
    }
}
