package com.ecomerce.backend.services;

import com.ecomerce.backend.controllers.exceptions.CustomException;
import com.ecomerce.backend.entities.Produto;
import com.ecomerce.backend.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Produto findById(Long id) {
        Optional<Produto> obj = this.productRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Produto não encontrado"));

    }

    public void removerEstoque(Long id, Integer quantity){
        Produto produto = findById(id);
        if(produto.getQuantity().equals(0)){
            throw new CustomException("Produto fora de estoque");
        } else if (quantity > produto.getQuantity()){
          throw new CustomException(
                  "Estoque indisponivel para a quantidade desejada. Estoque: "+ produto.getQuantity()+"  Quantidade pedido: "+ quantity);
        }
        produto.setQuantity(produto.getQuantity() - quantity);
    }

    public List<Produto> findAll() {
        return this.productRepository.findAll();
    }

    public Produto save(Produto objDTO) {
        return this.productRepository.save(objDTO);
    }

    public void delete(Long id){
        this.productRepository.deleteById(id);
    }


    @Transactional
    public Produto update(Long id, Produto produtoAtualizado) {
        Produto produtoExistente = productRepository.findById(id)
                .orElseThrow(() -> new CustomException("Produto não encontrado"));

        BeanUtils.copyProperties(produtoAtualizado, produtoExistente, "id");

        return productRepository.save(produtoExistente);
    }
}
