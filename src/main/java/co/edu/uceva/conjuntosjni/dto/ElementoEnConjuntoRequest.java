package co.edu.uceva.conjuntosjni.dto;

import lombok.Data;
/**
 * DTO que representa la petición para verificar si un elemento está en un conjunto
 */
@Data
public class ElementoEnConjuntoRequest {
    private int[] conjunto;
    private int elemento;
}