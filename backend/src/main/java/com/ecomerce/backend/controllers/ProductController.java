package com.ecomerce.backend.controllers;

import com.ecomerce.backend.entities.Produto;
import com.ecomerce.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public List<Produto> findAll(){
        return this.productService.findAll();
    }

    @GetMapping("/{id}")
    public Produto findById(@PathVariable("id") Long id){
        return this.productService.findById(id);
    }

    @PostMapping("/")
    public Produto save(@RequestBody Produto produto){
        return this.productService.save(produto);
    }

    @PutMapping("/")
    public Produto update(@RequestBody Produto produto){
        return this.productService.save(produto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        this.productService.delete(id);
    }

    @PatchMapping("/{id}")
    public Produto update(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        return productService.update(id, produtoAtualizado);
    }
}
