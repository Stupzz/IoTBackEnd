package com.iot.chaton.iot.domains;

import lombok.Data;

@Data
public class CaptorBacDto {
    private Long id;
    private float tauxHumidite;
    private float tauxLuminosite;
    private float temperature;
}
