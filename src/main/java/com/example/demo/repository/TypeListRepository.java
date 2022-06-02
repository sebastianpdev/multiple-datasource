package com.example.demo.repository;

import com.example.demo.entity.TipoLista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeListRepository extends JpaRepository<TipoLista, Long> {
}
