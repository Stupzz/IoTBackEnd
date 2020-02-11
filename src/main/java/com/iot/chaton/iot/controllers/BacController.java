package com.iot.chaton.iot.controllers;

import com.iot.chaton.iot.domains.Bac;
import com.iot.chaton.iot.exceptions.NotFoundException;
import com.iot.chaton.iot.repositories.BacRepositorie;
import com.iot.chaton.iot.services.BacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BacController {

    @Autowired
    private BacService bacService;

    @GetMapping("{id}")
    public Bac getBacById(@PathVariable Long id) throws NotFoundException {
        return bacService.getBacById(id);
    }

}
