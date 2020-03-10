package com.iot.chaton.iot.domains;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@NoArgsConstructor
public class HistoriqueBac implements Comparable<HistoriqueBac> {
    private Long bacId;
    private float tauxHumidite;
    private float tauxLuminosite;
    private float temperature;
    private Date date;

    @Override
    public int compareTo(HistoriqueBac candidate) {
        return getDate().compareTo(candidate.getDate());
    }

    public HistoriqueBac(Long bacId) {
        this.bacId = bacId;
        this.date = new Date();
    }

    public HistoriqueBac(Long bacId, float tauxHumidite, float tauxLuminosite, float temperature) {
        this.bacId = bacId;
        this.tauxHumidite = tauxHumidite;
        this.tauxLuminosite = tauxLuminosite;
        this.temperature = temperature;
        this.date = new Date();
    }
}
