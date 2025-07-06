/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author Sofia Romero
 */
public class HashTable {
    private HashNodo[] tabla;
    private int size;
    
    public HashTable(int size){
        this.size = size;
        tabla = new HashNodo[size];
    }
    
    private int hash(String clave){
        return Math.abs(clave.hashCode() % size);
       
    }
    
    public void Agregar(String clave, Informacion info){
        int opcion = hash(clave);
        HashNodo nuevo = new HashNodo(clave, info);
        
        nuevo.next = tabla[opcion];
        tabla[opcion]= nuevo;
        
    }
    public Informacion Buscar(String clave){
        int opcion = hash(clave);
        HashNodo actual = tabla[opcion];
        
        while (actual != null){
            if(actual.clave.equals(clave)){
                return actual.info;
                
            }
            actual = actual.next;
        }
        return null;
        
    }
    
    public HashNodo obtenerMasFrecuente() {
    HashNodo masFrecuente = null;

    for (int i = 0; i < tabla.length; i++) {
        HashNodo actual = tabla[i];
        while (actual != null) {
            if (masFrecuente == null || actual.info.frecuencia >
                masFrecuente.info.frecuencia) {
                masFrecuente = actual;
            }
            actual = actual.next;
        }
    }

    return masFrecuente;
}
    
    public HashNodo obtenerMenosFrecuente() {
    HashNodo menosFrecuente = null;

    for (int i = 0; i < tabla.length; i++) {
        HashNodo actual = tabla[i];
        while (actual != null) {
            if (actual.info.frecuencia > 0) {
                if (menosFrecuente == null || actual.info.frecuencia <
                    menosFrecuente.info.frecuencia) {
                    menosFrecuente = actual;
                }
            }
            actual = actual.next;
        }
    }

    return menosFrecuente;
}
    
    
}
