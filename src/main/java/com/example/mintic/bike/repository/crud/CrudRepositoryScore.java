package com.example.mintic.bike.repository.crud;

import org.springframework.data.repository.CrudRepository;
import com.example.mintic.bike.model.Score;

public interface CrudRepositoryScore extends CrudRepository<Score,Integer> {
    
}
