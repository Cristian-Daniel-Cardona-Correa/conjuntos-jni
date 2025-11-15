package co.edu.uceva.conjuntosjni.controller;

import co.edu.uceva.conjuntosjni.dto.ConjuntosRequest;
import co.edu.uceva.conjuntosjni.dto.ElementoEnConjuntoRequest;
import co.edu.uceva.conjuntosjni.service.ConjuntosService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/conjuntos-jni")
public class ConjuntosRestController {

    private final ConjuntosService conjuntosService;

    public ConjuntosRestController(ConjuntosService conjuntosService) {
        this.conjuntosService = conjuntosService;
    }

    @PostMapping("/esta-en-conjunto")
    public boolean estaEnConjunto(@RequestBody ElementoEnConjuntoRequest request) {
        return conjuntosService.estaEnConjunto(request.getConjunto(), request.getElemento());
    }

    @PostMapping("/union")
    public int[] unionConjuntos(@RequestBody ConjuntosRequest request) {
        return conjuntosService.union(request.getA(), request.getB());
    }

    @PostMapping("/interseccion")
    public int[] interseccionConjuntos(@RequestBody ConjuntosRequest request) {
        return conjuntosService.interseccion(request.getA(), request.getB());
    }

    @PostMapping("/diferencia")
    public int[] diferenciaConjuntos(@RequestBody ConjuntosRequest request) {
        return conjuntosService.diferencia(request.getA(), request.getB());
    }
}
