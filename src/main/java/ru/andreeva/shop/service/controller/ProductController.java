package ru.andreeva.shop.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.andreeva.shop.service.dao.Product;
import ru.andreeva.shop.service.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable("id") int id) {
        return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> add(@RequestBody Product product) {
        return ResponseEntity.ok(repository.save(product));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") int id, @RequestBody Product product) {
        if (id != product.getId() || repository.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(repository.save(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable("id") int id) {
        Optional<Product> product = repository.findById(id);
        if (product.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        repository.deleteById(id);
        return ResponseEntity.ok(product.get());
    }
}
