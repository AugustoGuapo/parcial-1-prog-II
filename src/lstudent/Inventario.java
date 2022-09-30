/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lstudent;

/**
 *
 * @author augusto
 */
public class Inventario {
    private Libro[] stock;
    private int nroLibros;
    
    public Inventario() {
        nroLibros = 12;
        stock = new Libro[nroLibros];
        stock[0] = new Libro("Una tierra prometida", "Biografía", 1196, 120000, 4);
        stock[1] = new Libro("Delirio", "Literatura", 303, 42000, 4);
        stock[2] = new Libro("Cien años de soledad", "Literatura", 471, 77000, 5);
        stock[3] = new Libro("Satanás", "Literatura", 128, 55000, 2);
        stock[4] = new Libro("El olvido que seremos","Biografía",280, 58000, 5);
        stock[5] = new Libro("Los ejércitos", "Literatura", 208, 43000, 4);
        stock[6] = new Libro("El ruido de las cosas al caer","Literatura", 232, 57000, 4);
        stock[7] = new Libro("Memoria por correspondencia", "Biografía", 230, 54000, 4);
        stock[8] = new Libro("Los cuatro monstruos cardinales", "Ensayo", 145, 90000, 3);
        stock[9] = new Libro("El artículo científico", "Divulgación", 237, 73000, 5);
        stock[10] = new Libro("Manual para la redacción del problema", "Texto", 108, 25000, 1);
        stock[11] = new Libro("Metodologia de la investigación II", "Texto", 965, 120000, 4);
    }
    
    private void setLibro(int pos, Libro l) {
        stock[pos] = l;
    }
    
    public void añadirLibro(Libro l) {
        aumentarArreglo();
        setLibro(nroLibros-1, l);
    }
    
    private void aumentarArreglo() {
        Libro[] aux = stock;
        nroLibros++;
        stock = new Libro[nroLibros];
        System.arraycopy(aux, 0, stock, 0, aux.length);
    }
    
    public Libro getLibro(int pos) {
        return stock[pos];
    }
    
    public int getNroLibros() {
        return nroLibros;
    }
    
    public float calcularPromedio() {
        float suma = 0;
        for (Libro libro : stock) {
            suma += libro.getPrecioVenta();
        }
        return suma/getNroLibros();
    }
    
    public void cambiar(int p1, int p2) {
        Libro aux = getLibro(p1);
        setLibro(p1, getLibro(p2));
        setLibro(p2, aux);
    }
    
    public void ordenarAlfabeticamente() {
        int i, n, cont;
        n = (getNroLibros()-1)/2;
        while(n != 0){
            cont = 1;
            while(cont != 0){
                cont = 0;
                for(i=n; i<=getNroLibros()-1; i++){
                    if(getLibro(i-n).compareTo(getLibro(i)) > 0){
                    cambiar(i, i-n);
                    cont = cont + 1;
                    }
                }
            }
        n = n/2;
        }
    }
    
    public void ordenarBurbuja() {
        for (int i = 0; i<=getNroLibros()-1; i++) {
            for (int j = 0; j <= (getNroLibros()-i)-2;j++) {
                if (getLibro(j).getNroPaginas() > getLibro(j+1).getNroPaginas()) {
                    cambiar(j, j+1);
                }
            }
        }
    }
    
    public void ordenarQuickSort(int primero, int ultimo){
        int i, j, centro;
        int pivote;
        centro = (primero+ultimo)/2;
        pivote = getLibro(centro).getNroPaginas();
        i = primero;
        j = ultimo;
        do {
            while((i <= j) && (getLibro(i).getNroPaginas() < pivote)){
            i = i + 1;
            }
            while((i <= j) && (getLibro(j).getNroPaginas() > pivote)){
            j = j - 1;
            }
            if(i <= j){
                cambiar(i, j);
                i = i + 1;
                j = j - 1;
            }
        }while(i <= j);
        if(primero < j){
            ordenarQuickSort(primero, j);
        }
        if(i < ultimo){
            ordenarQuickSort(i, ultimo);
        }
    }
    
    public void ordenarShell() {
        int i, n, cont;
        n = (getNroLibros()-1)/2;
        while(n != 0){
            cont = 1;
            while(cont != 0){
                cont = 0;
                for(i=n; i<=getNroLibros()-1; i++){
                    if(getLibro(i-n).getNroPaginas() > getLibro(i).getNroPaginas()){
                        cambiar(i, i-n);
                        cont = cont + 1;
                    }
                }
            }
            n = n/2;
        }
    }
    
    public int busquedaBinaria(String titulo){
        int posicion, izq, der, centro;
        ordenarAlfabeticamente(); 
        izq = 0; 
        der = getNroLibros()-1; 
        posicion = -1;
        while ((izq <= der) && (posicion == -1)){
            centro = (izq + der) / 2;
            if (titulo.equalsIgnoreCase(getLibro(centro).getTitulo())){
                posicion = centro;
           }else{
                if (titulo.compareToIgnoreCase(getLibro(centro).getTitulo()) < 0){
                    der = centro-1;
               }else{
                    izq = centro+1;
                }
           }       
        }
        return posicion;
    }
}
