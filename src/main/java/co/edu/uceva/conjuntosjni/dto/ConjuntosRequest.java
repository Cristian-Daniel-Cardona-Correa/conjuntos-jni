package co.edu.uceva.conjuntosjni.dto;

import lombok.Data;

/**
 * DTO que representa la petición para operaciones entre conjuntos
 */
@Data
public class ConjuntosRequest {
    private int[] A;
    private int[] B;
}
