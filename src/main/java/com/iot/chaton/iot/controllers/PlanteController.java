package com.iot.chaton.iot.controllers;

import com.iot.chaton.iot.domains.Plante;
import com.iot.chaton.iot.domains.PlanteDto;
import com.iot.chaton.iot.exceptions.NotFoundException;
import com.iot.chaton.iot.services.BacService;
import com.iot.chaton.iot.services.PlanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/plantes")
public class PlanteController {

    @Autowired
    private PlanteService planteService;

    @Autowired
    private BacService bacService;

    @GetMapping("{id}")
    private Plante getById(@PathVariable Long id) throws NotFoundException {
        return planteService.getPlanteById(id);
    }

    @PostMapping
    private Plante addPlante(@RequestBody PlanteDto planteDto) throws NotFoundException {
        Plante plante = planteService.createPlanteFromDto(planteDto);
        return planteService.addPlante(plante);
    }
}
