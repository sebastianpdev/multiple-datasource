package com.example.demo.service.impl;

import com.example.demo.entity.TipoLista;
import com.example.demo.repository.TypeListRepository;
import com.example.demo.service.ListTypeService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.Instant;
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

    @Override
    @Transactional
    public void saveListType() {
        for (int i = 0; i < 200; i++) {
            TipoLista tipoListaTemp = new TipoLista();
            tipoListaTemp.setNombre("Tipo Lista "+i);
            tipoListaTemp.setCreatedBy("F"+i);
            tipoListaTemp.setCreatedDate(Timestamp.from(Instant.now()));
            typeListRepository.save(tipoListaTemp);
        }
    }
}
