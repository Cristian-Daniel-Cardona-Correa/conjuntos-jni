package co.edu.uceva.conjuntosjni.controller;

import co.edu.uceva.conjuntosjni.dto.ConjuntosRequest;
import co.edu.uceva.conjuntosjni.dto.ElementoEnConjuntoRequest;
import libconjuntos.lib.JavaConjuntos;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/conjuntos-jni")
public class ConjuntosRestController {

    private final JavaConjuntos miConjunto;

    public ConjuntosRestController() {
        this.miConjunto = new JavaConjuntos();
    }

    @PostMapping("/esta-en-conjunto")
    public boolean estaEnConjunto(@RequestBody ElementoEnConjuntoRequest request) {
        int[] conjunto = request.getConjunto();
        int elemento = request.getElemento();

        int resultado = miConjunto.estaEnConjunto(elemento, conjunto, conjunto.length);
        return resultado == 1;
    }

    @PostMapping("/union")
    public int[] unionConjuntos(@RequestBody ConjuntosRequest request) {
        int[] resultado = new int[request.getA().length + request.getB().length];
        int n = miConjunto.unionConjuntos(request.getA(), request.getA().length,
                request.getB(), request.getB().length, resultado);
        int[] union = new int[n];
        System.arraycopy(resultado, 0, union, 0, n);
        return union;
    }

    @PostMapping("/interseccion")
    public int[] interseccionConjuntos(@RequestBody ConjuntosRequest request) {
        int[] resultado = new int[Math.min(request.getA().length, request.getB().length)];
        int n = miConjunto.interseccionConjuntos(request.getA(), request.getA().length,
                request.getB(), request.getB().length, resultado);
        int[] inter = new int[n];
        System.arraycopy(resultado, 0, inter, 0, n);
        return inter;
    }

    @PostMapping("/diferencia")
    public int[] diferenciaConjuntos(@RequestBody ConjuntosRequest request) {
        int[] resultado = new int[request.getA().length];
        int n = miConjunto.diferenciaConjuntos(request.getA(), request.getA().length,
                request.getB(), request.getB().length, resultado);
        int[] dif = new int[n];
        System.arraycopy(resultado, 0, dif, 0, n);
        return dif;
    }
}
