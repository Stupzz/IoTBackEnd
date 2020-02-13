package com.iot.chaton.iot.services;

import com.iot.chaton.iot.domains.Plante;
import com.iot.chaton.iot.domains.PlanteDto;
import com.iot.chaton.iot.exceptions.NotFoundException;
import com.iot.chaton.iot.repositories.PlanteRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanteService {

    @Autowired
    private PlanteRepositorie planteRepositorie;

    @Autowired
    private BacService bacService;

    public Plante getPlanteById(Long id) throws NotFoundException {
        return planteRepositorie.findById(id).orElseThrow(() ->new NotFoundException("Aucune plante trouvé avec cet id"));
    }

    public Plante addPlante(Plante plante){
        return planteRepositorie.save(plante);
    }

    public Plante createPlanteFromDto(PlanteDto planteDto) throws NotFoundException {
        Plante plante = new Plante();
        plante.setBac(bacService.getBacById(planteDto.getIdBac()));
        plante.setNom(planteDto.getNom());
        plante.setTauxHumiditeIdeal(planteDto.getTauxHumiditeIdeal());
        plante.setTauxLuminositeIdeal(planteDto.getTauxLuminositeIdeal());
        plante.setTemperatureIdeal(planteDto.getTemperatureIdeal());

        System.out.println("Voici la plante créer : ");
        System.out.println(plante);
        return plante;
    }
}
