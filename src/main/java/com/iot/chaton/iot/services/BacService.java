package com.iot.chaton.iot.services;

import com.iot.chaton.iot.domains.Bac;
import com.iot.chaton.iot.domains.BacDto;
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

    public Bac createBacFromDto(BacDto bacDto){
        Bac bac = new Bac();
        bac.setId(bacDto.getId());
        bac.setTauxHumiditeVoulu(bacDto.getTauxHumiditeVoulu());
        bac.setTauxLuminositeVoulu(bacDto.getTauxLuminositeVoulu());
        bac.setTemperatureVoulu(bacDto.getTemperatureVoulu());
        return bac;
    }

    public Bac updateVouluCaractFromDto(Bac bacToUpdate, BacDto bacDto){
        /*
            Met à jour les caractéristiques voulu (qui déclenchera les leds) d'un bac
         */
        if (bacDto.getTauxHumiditeVoulu().length == 2){
            bacToUpdate.setTauxHumiditeVoulu(bacDto.getTauxHumiditeVoulu());
        }
        if (bacDto.getTauxLuminositeVoulu().length == 2){
            bacToUpdate.setTauxLuminositeVoulu(bacDto.getTauxLuminositeVoulu());
        }
        if (bacDto.getTemperatureVoulu().length == 2){
            bacToUpdate.setTemperatureVoulu(bacDto.getTemperatureVoulu());
        }
        return bacToUpdate;
    }

    public Bac addOrEditOne(Bac bac){
        return bacRepositorie.save(bac);
    }

}
