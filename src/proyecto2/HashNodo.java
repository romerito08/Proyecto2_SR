package proyecto2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sofia Romero
 */
public class HashNodo{
    
    String clave;
    Informacion info;
    HashNodo next; 
    
    /**
     * Constructor que crea un nodo con su tripleta y su información asociada.
     * @param clave La tripleta que se quiere guardar.
     * @param info El objeto Informacion que contiene los datos del fragmento.
     */

    public HashNodo(String clave, Informacion info){
        this.clave = clave;
        this.info = info;
        this.next = null;
    }
 
}
