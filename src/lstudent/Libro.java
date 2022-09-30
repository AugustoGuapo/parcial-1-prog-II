/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lstudent;

/**
 *
 * @author augusto
 */
public class Libro implements Comparable<Libro>{
    private String titulo;
    private String genero;
    private int nroPaginas;
    private float precioVenta;
    private int puntuacion;

    public Libro() {
    }

    public Libro(String titulo, String genero, int nroPaginas, float precioVenta, int puntuacion) {
        this.titulo = titulo;
        this.genero = genero;
        this.nroPaginas = nroPaginas;
        this.precioVenta = precioVenta;
        this.puntuacion = puntuacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getNroPaginas() {
        return nroPaginas;
    }

    public void setNroPaginas(int nroPaginas) {
        this.nroPaginas = nroPaginas;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    @Override
    public int compareTo(Libro l) {
        return this.titulo.compareToIgnoreCase(l.getTitulo());
    }
    
    @Override
    public String toString() {
        return String.format("""
                             Titulo: %s
                             G\u00e9nero: %s
                             N\u00famero de p\u00e1ginas: %d
                             Valor: %.2f
                             Calificaci\u00f3n: %d""",
                this.titulo, this.genero, this.nroPaginas, 
                this.precioVenta, this.puntuacion);
    }
}
