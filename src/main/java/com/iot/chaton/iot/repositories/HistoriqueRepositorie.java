package com.iot.chaton.iot.repositories;

import com.iot.chaton.iot.domains.HistoriqueBac;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HistoriqueRepositorie extends MongoRepository<HistoriqueBac, Long> {
    public List<HistoriqueBac> findAllByBacId(Long id);
}
