/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author Sofia Romero
 */
public class Aminoacido {
    String nombre;
    String[] tripletas;
    
    /**
     * Constructor que crea un objeto Aminoacido con su nombre y las tripletas asociadas.
     *
     * @param nombre Nombre del aminoácido.
     * @param tripletas Tripletas de ADN que lo representan.
     */

    public Aminoacido(String nombre, String[] tripletas){
        this.nombre = nombre;
        this.tripletas = tripletas;
    }
    
}
