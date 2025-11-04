package libconjuntos.lib;

/**
 *  Clase que representa las funciones de la biblioteca dinamica JNI
 */

public class JavaConjuntos {

    public native int estaEnConjunto(int elemento, int[] conjunto, int n);

    public native int unionConjuntos(int[] A, int nA, int[] B, int nB, int[] resultado);

    public native int interseccionConjuntos(int[] A, int nA, int[] B, int nB, int[] resultado);

    public native int diferenciaConjuntos(int[] A, int nA, int[] B, int nB, int[] resultado);

    public JavaConjuntos() {
        try{
            System.loadLibrary("conjuntos_jni");
            System.out.println("Biblioteca cargada exitosamente!");
        }catch (UnsatisfiedLinkError e){
            System.err.println("Carga de la biblioteca fallida: " + e.getMessage());
        }
    }
}
