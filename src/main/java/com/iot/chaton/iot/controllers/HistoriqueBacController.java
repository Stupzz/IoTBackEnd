package com.iot.chaton.iot.controllers;

import com.iot.chaton.iot.domains.HistoriqueBac;
import com.iot.chaton.iot.exceptions.NotFoundException;
import com.iot.chaton.iot.services.HistoriqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/historique")
public class HistoriqueBacController {
    @Autowired
    private HistoriqueService historiqueService;

    @GetMapping("{id}")
    public List<HistoriqueBac> getBacById(@PathVariable Long id) {
        //mettre le cas de la demande de mail
        List<HistoriqueBac> historique = historiqueService.getAllbyBacId(id);
        Collections.sort(historique);
        return historique;
    }
}
