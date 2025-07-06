/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;


import java.util.ArrayList;

/**
 *
 * @author Sofia Romero
 */

/**
 * Clase que almacena información sobre un fragmento de ADN.
 * Guarda la frecuencia con la que aparece y las posiciones donde se detectó.
 */
public class Informacion {
    /** Número de veces que el fragmento ha aparecido en la secuencia. */
    /** Arreglo que contiene las posiciones donde aparece el fragmento. */
    /** Cantidad actual de posiciones guardadas. */

    int frecuencia;
    private int[] ubicaciones;
    private int size;
    
    /**
     * Constructor que inicializa la información del fragmento
     * Comienza con frecuencia 0 y espacio para 100 ubicaciones como máximo
     */

    public Informacion(){
        frecuencia = 0;
        ubicaciones = new int[100];
        size = 0;
    }
    
    /**
     * Agrega una nueva posición donde aparece el fragmento
     * También aumenta la frecuencia
     * @param ubicacion La posición (índice) en la secuencia donde se encontró
     */

    public void AgregarUbi(int ubicacion){
        if(size < ubicaciones.length){
            ubicaciones[size] = ubicacion;
            size++;
            frecuencia++;
        }
    }
    /**
     * Devuelve un nuevo arreglo con las posiciones registradas
     * Solo se devuelve hasta el tamaño actual (sin espacios vacíos)
     * @return Un arreglo de enteros con las ubicaciones válidas
     */
    public int[] getUbicaciones(){
        int[] otra = new int[size];
        for(int i=0; i < size; i++){
            otra[i] = ubicaciones[i];
        }
        return otra;
    }
    
    /**
     * Devuelve la frecuencia actual del fragmento
     * @return El número de apariciones del fragmento
     */

    public int getFrecuencia() {
        return frecuencia;
    }

}
