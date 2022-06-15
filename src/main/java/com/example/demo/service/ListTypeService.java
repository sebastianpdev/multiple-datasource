package com.example.demo.service;

import com.example.demo.entity.TipoLista;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ListTypeService {
    Page<TipoLista> list(Pageable page);
    void saveListType();
    void saveListOne();
}
