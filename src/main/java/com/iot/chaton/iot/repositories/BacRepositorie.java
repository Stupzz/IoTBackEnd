package com.iot.chaton.iot.repositories;

import com.iot.chaton.iot.domains.Bac;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BacRepositorie extends MongoRepository <Bac, Long> {
    public Optional<Bac> findById(Long id);
}
