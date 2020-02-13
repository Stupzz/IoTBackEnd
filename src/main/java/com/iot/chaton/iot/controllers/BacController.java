package com.iot.chaton.iot.controllers;

import com.iot.chaton.iot.domains.Bac;
import com.iot.chaton.iot.domains.BacDto;
import com.iot.chaton.iot.exceptions.NotFoundException;
import com.iot.chaton.iot.services.BacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BacController {

    @Autowired
    private BacService bacService;

    @GetMapping("{id}")
    public Bac getBacById(@PathVariable Long id) throws NotFoundException {
        return bacService.getBacById(id);
    }

    @PostMapping
    public Bac addBac(@RequestBody BacDto bacDto){
        Bac bac = bacService.createBacFromDto(bacDto);
        return bacService.addOrEditOne(bac);
    }

    @PostMapping("/editer")
    public Bac modifyBac(@RequestBody BacDto bacDto) throws NotFoundException {
        Bac bac = getBacById(bacDto.getId());
        bacService.updateVouluCaractFromDto(bac, bacDto);
        return bac;
    }

}
