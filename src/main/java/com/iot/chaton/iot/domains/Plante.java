package com.iot.chaton.iot.domains;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Plante {

    @Id
    private Long id;

    private Bac bac;

    private String nom;

    private float tauxHumiditeIdeal;
    private float tauxLuminositeIdeal;
    private float temperatureIdeal;
}
