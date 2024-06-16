package com.ecomerce.backend.repositories;

import com.ecomerce.backend.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Produto, Long> {
}
