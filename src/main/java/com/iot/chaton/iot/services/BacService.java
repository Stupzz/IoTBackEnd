package com.iot.chaton.iot.services;

import com.iot.chaton.iot.domains.Bac;
import com.iot.chaton.iot.exceptions.NotFoundException;
import com.iot.chaton.iot.repositories.BacRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BacService {

    @Autowired
    private BacRepositorie bacRepositorie;

    public Bac getBacById(Long id) throws NotFoundException {
        return bacRepositorie.findById(id).orElseThrow(() -> new NotFoundException("Aucun bac n'a était trouvé avec cet id"));
    }
}
