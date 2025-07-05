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
public class Informacion {
    private int frecuencia;
    private int[] ubicaciones;
    private int size;
    
    public Informacion(){
        frecuencia = 0;
        ubicaciones = new int[100];
        size = 0;
    }
    
    public void AgregarUbi(int ubicacion){
        if(size < ubicaciones.length){
            ubicaciones[size] = ubicacion;
            size++;
            frecuencia++;
        }
    }
    public int[] getUbicaciones(){
        int[] otra = new int[size];
        for(int i=0; i < size; i++){
            otra[i] = ubicaciones[i];
        }
        return otra;
    }
    public int getFrecuencia() {
        return frecuencia;
    }

}
