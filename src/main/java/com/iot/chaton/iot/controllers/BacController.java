package com.iot.chaton.iot.controllers;

import com.iot.chaton.iot.domains.Bac;
import com.iot.chaton.iot.domains.BacSettingDto;
import com.iot.chaton.iot.domains.CaptorBacDto;
import com.iot.chaton.iot.domains.HistoriqueBac;
import com.iot.chaton.iot.exceptions.NotFoundException;
import com.iot.chaton.iot.services.BacService;
import com.iot.chaton.iot.services.HistoriqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bacs")
public class BacController {

    @Autowired
    private BacService bacService;

    @Autowired
    private HistoriqueService historiqueService;

    @GetMapping("{id}")
    public Bac getBacById(@PathVariable Long id) throws NotFoundException {
        return bacService.getBacById(id);
    }

    @GetMapping
    public List<Bac> getAllBac() throws NotFoundException {
        return bacService.getAllBac();
    }

    @PostMapping
    public Bac addBac(@RequestBody int IdBac){
        Bac bac = bacService.createBacFromId(IdBac);
        return bacService.addOrEditOne(bac);
    }

    @PostMapping("/editer")
    public Bac modifyBac(@RequestBody BacSettingDto bacSettingDto) throws NotFoundException {
        System.out.println("BacDto");
        System.out.println(bacSettingDto);
        Bac bac = getBacById(bacSettingDto.getId());
        bacService.updateVouluCaractFromDto(bac, bacSettingDto);
        bacService.addOrEditOne(bac);
        return bacService.addOrEditOne(bac);
    }

    @PostMapping("/capteur")
    public Bac captorBacUpdate(@RequestBody CaptorBacDto captorBacDto) throws NotFoundException {
        System.out.println("BacDto");
        System.out.println(captorBacDto);
        Bac bac = getBacById(captorBacDto.getId());
        bacService.updateBacFromCaptorValueDto(bac, captorBacDto);
        bacService.addOrEditOne(bac);
        historiqueService.addOrEditOne(new HistoriqueBac(captorBacDto.getId()));
        return bacService.addOrEditOne(bac);
    }

}
