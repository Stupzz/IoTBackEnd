package com.iot.chaton.iot.domains;

import lombok.Data;

@Data
public class BacSettingDto {
    private Long id;
    private float[] tauxHumiditeVoulu;
    private float[] tauxLuminositeVoulu;
    private float[] temperatureVoulu;
}
