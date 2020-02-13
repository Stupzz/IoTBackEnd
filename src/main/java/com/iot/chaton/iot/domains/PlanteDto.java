package com.iot.chaton.iot.domains;

import lombok.Data;

@Data
public class PlanteDto {

    private Long idBac;

    private String nom;

    private float tauxHumiditeIdeal;
    private float tauxLuminositeIdeal;
    private float temperatureIdeal;
}
