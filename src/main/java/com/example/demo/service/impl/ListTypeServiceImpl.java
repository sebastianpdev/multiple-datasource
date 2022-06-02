package com.example.demo.service.impl;

import com.example.demo.entity.TipoLista;
import com.example.demo.repository.TypeListRepository;
import com.example.demo.service.ListTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListTypeServiceImpl implements ListTypeService {

    private final TypeListRepository typeListRepository;

    public ListTypeServiceImpl(TypeListRepository typeListRepository) {
        this.typeListRepository = typeListRepository;
    }

    @Override
    public List<TipoLista> list() {
        return this.typeListRepository.findAll();
    }
}
