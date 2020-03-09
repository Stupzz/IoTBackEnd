package com.iot.chaton.iot.services;

import com.iot.chaton.iot.domains.CaptorBacDto;
import com.iot.chaton.iot.domains.HistoriqueBac;
import com.iot.chaton.iot.repositories.HistoriqueRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriqueService {
    @Autowired
    private HistoriqueRepositorie historiqueRepositorie;

    public List<HistoriqueBac> getAllbyBacId(Long id){
        return historiqueRepositorie.findAllByBacId(id);
    }

    public HistoriqueBac addOrEditOne(HistoriqueBac historiqueBac){
        return historiqueRepositorie.save(historiqueBac);
    }

    public HistoriqueBac createFromCaptorDto(CaptorBacDto captorBacDto){
        return addOrEditOne(new HistoriqueBac(captorBacDto.getId(), captorBacDto.getTauxHumidite(), captorBacDto.getTauxLuminosite(), captorBacDto.getTemperature()));
    }
}
