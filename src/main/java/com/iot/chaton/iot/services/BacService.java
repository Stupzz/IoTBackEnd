package com.iot.chaton.iot.services;

import com.iot.chaton.iot.domains.Bac;
import com.iot.chaton.iot.domains.BacSettingDto;
import com.iot.chaton.iot.domains.CaptorBacDto;
import com.iot.chaton.iot.exceptions.NotFoundException;
import com.iot.chaton.iot.repositories.BacRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BacService {

    @Autowired
    private BacRepositorie bacRepositorie;

    public Bac getBacById(Long id) throws NotFoundException {
        return bacRepositorie.findById(id).orElseThrow(() -> new NotFoundException("Aucun bac n'a était trouvé avec cet id"));
    }

    public Bac createBacFromId(int idBac){
        Bac bac = new Bac();
        bac.setId(Long.valueOf(idBac));
        return bac;
    }

    public Bac createBacFromDto(BacSettingDto bacSettingDto){
        Bac bac = new Bac();
        bac.setId((long) bacSettingDto.getId());
        bac.setTauxHumiditeVoulu(bacSettingDto.getTauxHumiditeVoulu());
        bac.setTauxLuminositeVoulu(bacSettingDto.getTauxLuminositeVoulu());
        bac.setTemperatureVoulu(bacSettingDto.getTemperatureVoulu());
        return bac;
    }

    public Bac updateVouluCaractFromDto(Bac bacToUpdate, BacSettingDto bacSettingDto){
        /*
            Met à jour les caractéristiques voulu (qui déclenchera les leds) d'un bac
         */
        if (bacSettingDto.getTauxHumiditeVoulu().length == 2){
            bacToUpdate.setTauxHumiditeVoulu(bacSettingDto.getTauxHumiditeVoulu());
        }
        if (bacSettingDto.getTauxLuminositeVoulu().length == 2){
            bacToUpdate.setTauxLuminositeVoulu(bacSettingDto.getTauxLuminositeVoulu());
        }
        if (bacSettingDto.getTemperatureVoulu().length == 2){
            bacToUpdate.setTemperatureVoulu(bacSettingDto.getTemperatureVoulu());
        }
        return bacToUpdate;
    }


    public Bac updateBacFromCaptorValueDto(Bac bacToUpdate, CaptorBacDto captorBacDto){
        /*
            Met à jour les taux d'u bac
         */
       bacToUpdate.setTauxHumidite(captorBacDto.getTauxHumidite());
       bacToUpdate.setTauxLuminosite(captorBacDto.getTauxLuminosite());
       bacToUpdate.setTemperature(captorBacDto.getTemperature());
        return bacToUpdate;
    }

    public Bac addOrEditOne(Bac bac){
        return bacRepositorie.save(bac);
    }

    public List<Bac> getAllBac(){return bacRepositorie.findAll();}

}
