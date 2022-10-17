package com.example.mintic.bike.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mintic.bike.repository.RepositoryScore;

@Service
public class ServiceScore {
    
    @Autowired
    private RepositoryScore repositoryScore;
}
