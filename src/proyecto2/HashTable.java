/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author Sofia Romero
 */

/**
 * Clase que representa una tabla hash simple para almacenar fragmentos de ADN.
 * Utiliza listas enlazadas para manejar colisiones.
 */
public class HashTable {
    private HashNodo[] tabla; // Arreglo que almacena los buckets de la tabla
    private int size;          // Cantidad de posiciones 
    
    /**
     * Constructor de la tabla hash.
     * @param size Número de posiciones o capacidad inicial de la tabla.
     */
    
    public HashTable(int size){
        this.size = size;
        tabla = new HashNodo[size];
    }
    
    /**
     * Función que convierte una clave en una posición dentro del arreglo.
     * @param clave La cadena que representa el fragmento de ADN.
     * @return Índice calculado dentro de la tabla.
     */
    private int hash(String clave){
        return Math.abs(clave.hashCode() % size);
       
    }
        /**
     * Inserta un nuevo fragmento con su información en la tabla.
     * Si ya existe un fragmento en esa posición, se inserta al inicio de la lista enlazada.
     * @param clave Tripleta de ADN que se va a guardar.
     * @param info Objeto que contiene frecuencia y ubicaciones del fragmento.
     */

    public void Agregar(String clave, Informacion info){
        int opcion = hash(clave);
        HashNodo nuevo = new HashNodo(clave, info);
        
        nuevo.next = tabla[opcion];
        tabla[opcion]= nuevo;
        
    }
    
    /**
     * Busca una tripleta dentro de la tabla hash.
     *
     * @param clave La tripleta que se desea buscar.
     * @return El objeto Informacion asociado a la clave, o null si no se encontró.
     */
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
    
    /**
     * Recorre toda la tabla y devuelve el nodo con mayor frecuencia de aparición.
     *
     * @return El HashNodo con el fragmento que aparece más veces en la secuencia.
     */
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
    /**
     * Recorre toda la tabla y devuelve el nodo con menor frecuencia de aparición,
     * excluyendo los que tienen frecuencia 0.
     *
     * @return El HashNodo con el fragmento menos repetido en la secuencia.
     */
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
     /**
     * Genera un texto con todos los fragmentos almacenados en la tabla hash,
     * mostrando su frecuencia y las posiciones donde aparecen
     *
     * @return Una cadena con la información completa de cada tripleta.
     */

    public String todos() {
        String muestra = "";
        for (int i = 0; i < tabla.length; i++) {
            HashNodo actual = tabla[i];
            while (actual != null) {
                muestra += "El patron es: " + actual.clave+ " La frecuencia es: " + actual.info.frecuencia;
                muestra = muestra + "\nUbicaciones\n";
                int n = actual.info.getUbicaciones().length;
                
                for (int j=0; j< n ; j++){
                    muestra = muestra + actual.info.getUbicaciones()[j] + ", ";
                }
                muestra += "\n \n";
                actual = actual.next;
                
            }
        }

        return muestra;
    }

    /**
     * Recorre la tabla hash y genera un reporte de colisiones.
     * Muestra las posiciones donde hay más de un fragmento almacenado en el mismo índice.
     *
     * @return Una cadena con los índices colisionados y las tripletas que cayeron ahí.
     */

    public String reporteColisiones() {
    
        String printear = "";
        
        for (int i = 0; i < tabla.length; i++) {
            HashNodo actual = tabla[i];
            int contador = 0;
            
            while (actual != null) {
                contador++;
                actual = actual.next;
            }
            if (contador > 1) {
                printear += " Posicion: " + i + " Colisiones: " + contador;
                actual = tabla[i];
                while (actual != null) {
                    printear += "\n- Tripleta: " + actual.clave + " Frecuencia: " + actual.info.frecuencia;
                    actual = actual.next;
                }
                printear += "\n \n";
            }
        }
        return printear;
    }
    
    /**
     * Busca todas las tripletas asociadas a cada aminoácido en la lista.
     * Para cada aminoácido, muestra las tripletas que aparecieron y su frecuencia.
     *
     * @param listaAminoacidos Arreglo con objetos de tipo Aminoacido.
     * @return Una cadena con la información agrupada por aminoácido.
     */
    public String listarTripletasPorAminoacido(Aminoacido[] listaAminoacidos) {
        String total = "";
        for (int i = 0; i < listaAminoacidos.length; i++) {
            String tripletas = "";
            Aminoacido aa = listaAminoacidos[i];
            tripletas += ("Aminoácido: " + aa.nombre);

            for (int j = 0; j < aa.tripletas.length; j++) {
                String tripleta = aa.tripletas[j];
                Informacion info = this.Buscar(tripleta);

                if (info != null && info.frecuencia > 0) {
                    tripletas += ("\nTripleta: " + tripleta + "\nFrecuencia: " + info.frecuencia);
                }
            }
            
            if (tripletas == "") {
                tripletas += ("No se encontraron tripletas en la secuencia");
            }
            total += tripletas + "\n\n";
        }
        return total;
    }

}
