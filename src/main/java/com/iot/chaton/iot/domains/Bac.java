package com.iot.chaton.iot.domains;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Bac {

    @Id
    private Long id;

    private List<Plante> plantes;

    private float tauxHumidite;
    private float tauxLuminosite;
    private float temperature;

    /**Pour les tableaux si-dessous,
     * la première valeur sera la valeur minimal qui correspond à  l'affichage de la led -
     * la deuxième valeur sera la valeur maximal qui correspond à  l'affichage de la led +
     */
    private float[] tauxHumiditeVoulu = new float[2];
    private float[] tauxLuminositeVoulu = new float[2];
    private float[] temperatureVoulu = new float[2];
}
