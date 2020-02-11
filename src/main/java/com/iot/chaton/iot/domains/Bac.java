package com.iot.chaton.iot.domains;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Bac {

    @Id
    private Long id;

    private float tauxHumidite;
    private float tauxLuminosite;
    private float temperature;

    private float tauxHumiditeVoulu;
    private float tauxLuminositeVoulu;
    private float temperatureVoulu;
}
