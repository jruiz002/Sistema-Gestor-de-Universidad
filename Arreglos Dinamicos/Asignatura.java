public class Asignatura {
    // Atributos clase
    private String nombre;
    private double nota;
    
    /**
     * 
     * @param nombre parámetro que almacena el nombre de la clase
     * @param nota parámetro que almacena la nota de la clase
     */
    public Asignatura(String nombre, double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    /**
     * 
     * @return devuelve el nombre de la clase
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * 
     * @param nombre establece el nombre del parámetro
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return devuelve la nota de la clase
     */
    public double getNota() {
        return this.nota;
    }

    /**
     * 
     * @param nota establece la nota de la clase
     */
    public void setNota(double nota) {
        this.nota = nota;
    }


    /**
     * Muestra la información del método
     */
    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", nota='" + getNota() + "'" +
            "}";
    }


    
}
