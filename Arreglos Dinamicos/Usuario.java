import java.util.ArrayList;
import java.util.Date;

public class Usuario {
    //Atributos clase
    private int id;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String email;
    private ArrayList<Asignatura> asignaturas;


    /**
     * 
     * @param id parámetro que almacena el id del usuario
     * @param nombre parámetro que almacena el nombre del usuario
     * @param apellido parámetro que almacena el apellido del usuario
     * @param fechaNacimiento parámetro que almacena la fecha de nacimiento del usuario
     * @param email parámetro que almacena el email del usuario
     */
    public Usuario(int id, String nombre, String apellido, Date fechaNacimiento, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.asignaturas = new ArrayList<Asignatura>();
    }

    /**
     * 
     * @return devuelve el id del usuario
     */
    public int getId() {
        return this.id;
    }

    /**
     * 
     * @param id establece el id del usuario.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 
     * @return devuelve el nombre de usuario
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * 
     * @param nombre establece el nombre del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return devuelve el apellido del usuario
     */
    public String getApellido() {
        return this.apellido;
    }

    /**
     * 
     * @param apellido establece el apellido del usuario
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * 
     * @return devuelve la fecha de nacimiento del usuario.
     */
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    /**
     * 
     * @param fechaNacimiento establece la fecha de nacimiento del usuario
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * 
     * @return devuelve el email del usuario
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * 
     * @param email establece el email del usuario
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return devuelve las asignaturas del usuario
     */
    public ArrayList<Asignatura> getAsignaturas() {
        return this.asignaturas;
    }

    /**
     * 
     * @param asignaturas establece las asignaturas del usuario
     */
    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    /**
     * 
     * @param asignatura establece la nota de la asignatura
     */
    public void agregarNotaAsignatura(Asignatura asignatura){
        asignaturas.add(asignatura);
    }

    /**
     * Muestra la información de un objeto de tipo usuario.
     */
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", apellido='" + getApellido() + "'" +
            ", fechaNacimiento='" + getFechaNacimiento() + "'" +
            ", email='" + getEmail() + "'" +
            ", asignaturas='" + getAsignaturas() + "'" +
            "}";
    }

}
