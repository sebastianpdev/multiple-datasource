package com.example.demo.service;

import com.example.demo.entity.TipoLista;

import java.util.List;

public interface ListTypeService {
    List<TipoLista> list();

    void saveListType();
}
