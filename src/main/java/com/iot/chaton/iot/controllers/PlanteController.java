package com.iot.chaton.iot.controllers;

import com.iot.chaton.iot.domains.Plante;
import com.iot.chaton.iot.exceptions.NotFoundException;
import com.iot.chaton.iot.services.PlanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/plantes")
public class PlanteController {

    @Autowired
    private PlanteService planteService;

    @GetMapping("{id}")
    private Plante getById(@PathVariable Long id) throws NotFoundException {
        return planteService.getPlanteById(id);
    }
}
