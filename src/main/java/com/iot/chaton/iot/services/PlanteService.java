package com.iot.chaton.iot.services;

import com.iot.chaton.iot.domains.Plante;
import com.iot.chaton.iot.exceptions.NotFoundException;
import com.iot.chaton.iot.repositories.PlanteRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanteService {

    @Autowired
    private PlanteRepositorie planteRepositorie;

    public Plante getPlanteById(Long id) throws NotFoundException {
        Plante plante = planteRepositorie.findById(id).orElseThrow(() ->new NotFoundException("Aucune plante trouvé avec cet id"));
        return plante;
    }

}
