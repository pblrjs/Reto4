package com.example.mintic.bike.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mintic.bike.repository.crud.CrudRepositoryAdmin;

@Repository
public class RepositoryAdmin {
    
    @Autowired
    private CrudRepositoryAdmin crudRepositoryAdmin;
}
