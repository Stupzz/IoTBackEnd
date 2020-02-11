package com.iot.chaton.iot.repositories;

import com.iot.chaton.iot.domains.Plante;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PlanteRepositorie extends MongoRepository <Plante, Long> {
    public Optional<Plante> findById(Long id);
}
