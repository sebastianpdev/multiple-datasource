package com.example.demo.service.impl;

import com.example.demo.entity.Rol;
import com.example.demo.repository.RolRepository;
import com.example.demo.service.RolService;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;

    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public List<Rol> list() {
        return this.rolRepository.findAll();
    }
}
