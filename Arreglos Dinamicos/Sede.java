import java.util.ArrayList;

public class Sede {
    /**
     * Atributos
     */
    private int id;
    private String nombre;
    private ArrayList<Usuario> usuarios;

    /**
     * 
     * @param id parámetro que almacena el id de la sede
     * @param nombre parámetro que almacena el nombre del usuario
     */
    public Sede(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.usuarios = new ArrayList<Usuario>();
    }

    /**
     * 
     * @return devuelve el id de la sede
     */
    public int getId() {
        return this.id;
    }

    /**
     * 
     * @param id establece el id de la sede
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 
     * @return devuelve el nombre de la sede
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * 
     * @param nombre establece el nombre de la sede
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return devuelve los usuarios de las sede
     */
    public ArrayList<Usuario> getUsuarios() {
        return this.usuarios;
    }

    /**
     * 
     * @param usuarios establece los usuarios de la sede
     */
    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * 
     * @param usuario parámetro que almacena el usuario a agregar.
     */
    public void agregarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }


    /**
     * Muestra la información de un objeto de tipo sede.
     */
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", usuarios='" + getUsuarios() + "'" +
            "}";
    }




}
