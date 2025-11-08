package co.edu.uceva.conjuntosjni.service;

import libconjuntos.lib.JavaConjuntos;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class ConjuntosService {

    private final JavaConjuntos miConjunto;

    public ConjuntosService() {
        this.miConjunto = new JavaConjuntos();
    }

    private int[] eliminarDuplicados(int[] conjunto) {
        if (conjunto == null) return new int[0];
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : conjunto) {
            set.add(num);
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    public boolean estaEnConjunto(int[] conjunto, int elemento) {
        int[] limpio = eliminarDuplicados(conjunto);
        int resultado = miConjunto.estaEnConjunto(elemento, limpio, limpio.length);
        return resultado == 1;
    }

    public int[] union(int[] A, int[] B) {
        int[] limpioA = eliminarDuplicados(A);
        int[] limpioB = eliminarDuplicados(B);
        int[] resultado = new int[limpioA.length + limpioB.length];
        int n = miConjunto.unionConjuntos(limpioA, limpioA.length, limpioB, limpioB.length, resultado);
        return Arrays.copyOf(resultado, n);
    }

    public int[] interseccion(int[] A, int[] B) {
        int[] limpioA = eliminarDuplicados(A);
        int[] limpioB = eliminarDuplicados(B);
        int[] resultado = new int[Math.min(limpioA.length, limpioB.length)];
        int n = miConjunto.interseccionConjuntos(limpioA, limpioA.length, limpioB, limpioB.length, resultado);
        return Arrays.copyOf(resultado, n);
    }

    public int[] diferencia(int[] A, int[] B) {
        int[] limpioA = eliminarDuplicados(A);
        int[] limpioB = eliminarDuplicados(B);
        int[] resultado = new int[limpioA.length];
        int n = miConjunto.diferenciaConjuntos(limpioA, limpioA.length, limpioB, limpioB.length, resultado);
        return Arrays.copyOf(resultado, n);
    }
}
