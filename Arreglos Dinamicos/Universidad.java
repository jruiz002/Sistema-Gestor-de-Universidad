import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class Universidad {
    /**
     * Atributos de clase
     */
    private String nombre;
    private ArrayList<Sede> sedes;

    /**
     * 
     * @param nombre parámetro que almacena el nombre de la universidad
     */
    public Universidad(String nombre) {
        this.nombre = nombre;
        this.sedes = new ArrayList<Sede>();
    }
    
    /**
     * 
     * @return devuelve el nombre de la universidad
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * 
     * @param nombre establece el nombre de la universidad.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @param sede parámetro que almacena la sede a agregar.
     */
    public void agregarSede(Sede sede){
        sedes.add(sede);
    }

    /**Método para mostrar las sedes */
    public void mostrarSedes(){
        for (int i = 0; i < sedes.size(); i++){
            System.out.println(i + ". " + sedes.get(i).getNombre());
        }
    }

    /**
     * 
     * @param indexSede parámatro que almacena el id de la sede en la cual se estará trabajando
     */
    public void controlSede(int indexSede){
        // Variables del método
        Scanner sc = new Scanner(System.in);
        boolean bandera = true;
        int opcion = 0;

        // Loop que controla el flujo del sub menu.
        while(bandera){
            try{
                menuControlSede(indexSede);
                opcion = sc.nextInt();
                if (opcion == 1){ // 1. Agregar estudiante.
                    agregarEstudiante(indexSede);

                }else if (opcion == 2){ // 2. Establecer nota a estudiante.
                    establecerNota(indexSede);
                    
                }else if (opcion == 3){ // 3. Mostrar análisis estadístico sede.
                    analisisEstadistico(indexSede);
                    
                }else if (opcion == 4){ // 4. Cantidad de alumnos por sede.
                    cantidadAlumnos();

                }else if (opcion == 5){ // 5. Nota más alta y más baja de los exámenes de la sede.
                    notas(indexSede);

                }else if (opcion == 6){ // 6. Regresar menú principal.
                    bandera = false;
                    System.out.println();

                }else{
                    System.out.println("Opción no disponible, ingrese una opción válida.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida, debe ingresar un número entero.");
                System.out.println();
                sc.nextLine();
            }
        }
    }

    /**
     * 
     * @param indexSede parámetro que almacena el id de la sede en la cuál se estará trabajando
     */
    public void menuControlSede(int indexSede){
        Sede sede = sedes.get(indexSede);
        System.out.println("----------------" +  sede.getNombre()  + "----------------");
        System.out.println("1. Agregar estudiante. ");
        System.out.println("2. Establecer nota a estudiante. ");
        System.out.println("3. Mostrar análisis estadístico sede. ");
        System.out.println("4. Cantidad de alumnos por sede. ");
        System.out.println("5. Nota más alta y más baja de los exámenes de la sede. ");
        System.out.println("6. Regresar menú principal. ");
        System.out.println("--------------------------------------");
    }

    /**
     * 
     * @param idSede parámetro que almacena el id de la sede en la cuál se estará trabajando
     */
    public void agregarEstudiante(int idSede){
        // Variables del método
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            // Datos para ingresar
            System.out.println("Ingrese el id del estudiante: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Ingrese el nombre del estudiante: ");
            String nombre = sc.nextLine();
            System.out.println("Ingrese el apellido del estudiante: ");
            String apellido = sc.nextLine();
            System.out.println("Ingrese la fecha de nacimiento de su cliente (dd/MM/yyyy): ");
            String fechaString = sc.nextLine();
            Date fecha = sdf.parse(fechaString);
            System.out.println("Ingrese el email del estudiante: ");
            String email = sc.nextLine();
            // Creación de instancia
            Usuario usuario = new Usuario(id, nombre, apellido, fecha, email);

            //Busqueda de sede indicada
            Sede sede = sedes.get(idSede);

            //Agregación de alumno a sede
            sede.agregarUsuario(usuario);

            System.out.println("¡Estudiante agregado exitosamente!");

        } catch (ParseException e) {
            System.out.println("Formato de fecha incorrecto. Utilice dd/MM/yyyy.");
            System.out.println();
            sc.nextLine();
        } catch (InputMismatchException e) {//Hay que dar enter para que continue el programa
            System.out.println("Entrada inválida, debe ingresar un número entero");
            System.out.println();
            sc.nextLine();
        }
    }

    /**
     * 
     * @param idSede parámetro que almacena el id de la sede en la cuál se estará trabajando
     */
    public void establecerNota(int idSede){
        Scanner sc = new Scanner(System.in);
        try{
            // Se selecciona la sede en la que se estará trabajando.
            Sede sede = sedes.get(idSede);
            System.out.println("Seleccione al estudiante que desea agregarle nota de examen: ");
            
            // Se muestra el listado de alumnos en esa sede.
            for (int i = 0; i < sede.getUsuarios().size(); i++){
                System.out.println(i + ". " + sede.getUsuarios().get(i).getNombre() + " " + sede.getUsuarios().get(i).getApellido());
            }
            int idUser = sc.nextInt();

            // Se almacena el usuario seleccionado
            Usuario usuario = sede.getUsuarios().get(idUser);

            // Se crea un arreglo con las clases disponibles:
            List<String> asignaturas = new ArrayList<>(List.of("Matemática", "Lenguaje", "Química", "Física", "Comprensión Lectora", "Estadística"));
            System.out.println();
            System.out.println("Seleccione la clase que desea asignar nota: ");
            for (int i = 0; i < asignaturas.size(); i++){
                System.out.println(i + ". " + asignaturas.get(i));
            }
            int idMateriaSeleccionda = sc.nextInt();

            System.out.println("Ingrese la nota (1 - 100) que obtuvo " + usuario.getNombre() + " " + usuario.getApellido());
            double nota = sc.nextDouble();

            Asignatura asignatura = new Asignatura(asignaturas.get(idMateriaSeleccionda), nota);

            //Se agrega la asignatura al usuario
            usuario.agregarNotaAsignatura(asignatura);
            System.out.println("Notas de exámenes actuales: ");
            for(int i = 0; i < usuario.getAsignaturas().size(); i++){
                System.out.println(usuario.getAsignaturas().get(i).toString());
            }
        }catch(InputMismatchException e){
            System.out.println("Entrada inválida, debe ingresar un número entero");
            System.out.println();
            sc.nextLine();
        }

    }

    /**
     * 
     * @param idSede parámetro que almacena el id de la sede en la cuál se estará trabajando
     */
    public void analisisEstadistico(int idSede){
        Scanner sc = new Scanner(System.in);
        try{
            Sede sede = sedes.get(idSede);
            // La lista que contendrá todas las notas de sus estudiantes.
            ArrayList <Asignatura> asignaturasSede = new ArrayList<Asignatura>();

            // Lista que almacena las clases que se encuentran en esa sede
            ArrayList <String> nombreAsignaturas = new ArrayList<String>();

            // Se agregan las notas de la sede a la lista
            for (Usuario user : sede.getUsuarios()) {
                for (Asignatura asignatura : user.getAsignaturas()) {
                    asignaturasSede.add(asignatura);
                    if (!nombreAsignaturas.contains(asignatura.getNombre())){
                        nombreAsignaturas.add(asignatura.getNombre());
                    }
                }
            }

            //Promedio
            promedio(asignaturasSede, nombreAsignaturas);

            //Mediana
            mediana(asignaturasSede, nombreAsignaturas);

            //Moda
            moda(asignaturasSede, nombreAsignaturas);

            //Desviación estándar
            desvEstandar(asignaturasSede, nombreAsignaturas);

        }catch(InputMismatchException e){
            System.out.println("Entrada inválida, debe ingresar un número entero");
            System.out.println();
            sc.nextLine();
        }
    }

    /**
     * 
     * @param asignaturasSede parámetro que almacena todas las notas de los estudiantes de la sede.
     * @param nombreAsignaturas parámetro que almacena el nombre de la clases con las que se estará trabajando
     */
    public void promedio(ArrayList <Asignatura> asignaturasSede, ArrayList <String> nombreAsignaturas){
        double total = 0;
        int contador = 0;
        System.out.println("----------------PROMEDIOS----------------");
        for (String nombreAsignatura : nombreAsignaturas) {
            // Filtro de clases de una sede.
            for (Asignatura asignaturaSede : asignaturasSede) {
                if(asignaturaSede.getNombre().equals(nombreAsignatura)){
                    total += asignaturaSede.getNota();
                    contador += 1;
                }
            }
            System.out.println("Promedio " + nombreAsignatura + ": " + (total/contador));
            total = 0;
            contador = 0;
        }
        System.out.println();
    }

    /**
     * 
     * @param asignaturasSede parámetro que almacena todas las notas de los estudiantes de la sede.
     * @param nombreAsignaturas parámetro que almacena el nombre de la clases con las que se estará trabajando
     */
    public void mediana(ArrayList <Asignatura> asignaturasSede, ArrayList <String> nombreAsignaturas){
        ArrayList<Double> notas = new ArrayList<Double>();
        System.out.println("----------------MEDIANAS----------------");
        for (String nombreAsignatura : nombreAsignaturas){
            // Filtro de clases de una sede.
            for (Asignatura asignaturaSede : asignaturasSede) {
                if(asignaturaSede.getNombre().equals(nombreAsignatura)){ 
                    notas.add(asignaturaSede.getNota());
                }
            }
            //Se ordena el arraylist, para poder calcular la media de las clases de la sede.
            Collections.sort(notas);
            
            // Calcular la mediana
            double mediana;
            int n = notas.size();

            if (n % 2 == 0) {
                // Si hay un número par de elementos, la mediana es el promedio de los dos números centrales
                int indice1 = n / 2 - 1;
                int indice2 = n / 2;
                double numero1 = notas.get(indice1);
                double numero2 = notas.get(indice2);
                mediana = (numero1 + numero2) / 2.0;
            }else {
                // Si hay un número impar de elementos, la mediana es el número central
                int indiceCentral = n / 2;
                mediana = notas.get(indiceCentral);
            }

            // Se muestra el resultado de la mediana de la clase.
            System.out.println("La mediana de " + nombreAsignatura + " es: " + mediana);
            notas.clear();
        }
        System.out.println();
    }

    /**
     * 
     * @param asignaturasSede parámetro que almacena todas las notas de los estudiantes de la sede.
     * @param nombreAsignaturas parámetro que almacena el nombre de la clases con las que se estará trabajando
     */
    public void moda(ArrayList <Asignatura> asignaturasSede, ArrayList <String> nombreAsignaturas){
        System.out.println("----------------MODAS----------------");
        ArrayList<Double> notas = new ArrayList<Double>();
        for (String nombreAsignatura : nombreAsignaturas) {
            // Filtro de clases de una sede.
            for (Asignatura asignaturaSede : asignaturasSede) {
                if(asignaturaSede.getNombre().equals(nombreAsignatura)){
                    notas.add(asignaturaSede.getNota());
                }
            }

            // Se crea para llevar el control de las frecuencias las veces que aparece una nota.
            Map<Double, Integer> frecuencia = new HashMap<>();

            // Contar la frecuencia de cada elemento
            for (double elemento : notas) {
                frecuencia.put(elemento, frecuencia.getOrDefault(elemento, 0) + 1);
            }
    
            Double moda = 0.0;
            int frecuenciaMaxima = 0;
    
            // Encontrar el elemento con la frecuencia máxima
            for (Entry<Double, Integer> entry : frecuencia.entrySet()) {
                if (entry.getValue() > frecuenciaMaxima) {
                    moda = entry.getKey();
                    frecuenciaMaxima = entry.getValue();
                }
            }
    
            System.out.println("- " + nombreAsignatura + ": " + moda);
            notas.clear();
        }
        System.out.println();
    }

    /**
     * 
     * @param asignaturasSede parámetro que almacena todas las notas de los estudiantes de la sede.
     * @param nombreAsignaturas parámetro que almacena el nombre de la clases con las que se estará trabajando
     */
    public void desvEstandar(ArrayList <Asignatura> asignaturasSede, ArrayList <String> nombreAsignaturas){
        ArrayList<Double> notas = new ArrayList<Double>();
        System.out.println("----------------DESVIACIONES ESTÁNDAR----------------");
        for (String nombreAsignatura : nombreAsignaturas) {
            // Filtro de clases de una sede.
            for (Asignatura asignaturaSede : asignaturasSede){
                if(asignaturaSede.getNombre().equals(nombreAsignatura)){
                    notas.add(asignaturaSede.getNota());
                }
            }
            try {
                // Se calcula la media
                double media = calcularMediaDesv(notas);
                System.out.println("- " + nombreAsignatura + ": " + calculosDesvEstandar(notas, media));
                // Se limpia el arreglo para la proxima clase
                notas.clear();               
            } catch (Exception e) {
                System.out.println("Se requieren al menos dos números para calcular la desviación estándar de " + nombreAsignatura);
            }
        }
        System.out.println();
    }

    /**
     * 
     * @param notas recibe las notas correspondiente para realizar el cálculo
     * @return devuelve la media de la notas proporcionadas
     */
    public double calcularMediaDesv(ArrayList<Double> notas) {
        double suma = 0.0;
        // Se recorre la lista de las notas
        for (Double nota : notas) {
            suma += nota;
        }
        return suma / notas.size();
    }

    /**
     * 
     * @param notas recibe las notas correspondiente para realizar el cálculo
     * @param media media de la notas proporcionadas
     * @return
     */
    public double calculosDesvEstandar(ArrayList<Double> notas, double media){
        double sumaCuadrados = 0.0;
        // Se recorre la lista de las notas
        for (Double nota : notas) {
            double diferencia = nota - media;
            // Se eleva al cuadrado
            sumaCuadrados += Math.pow(diferencia, 2);
        }
        // Se calcula la varianza
        double varianza = sumaCuadrados / (notas.size() - 1);
        // Se obtiene la raiz cuadrada de la varianza, lo que dará como resultado la desviación estándar de la clase.
        double desvEstandar = Math.sqrt(varianza);
        return desvEstandar;
    }

    /**
     * 
     * @param indexSede parámetro que almacena el indice de la sede en la cuál se estará trabajando
     */
    public void notas(int indexSede){
        ArrayList<Double> notas = new ArrayList<Double>();
        Sede sede = sedes.get(indexSede);
        // La lista que contendrá todas las notas de sus estudiantes.
        ArrayList <Asignatura> asignaturasSede = new ArrayList<Asignatura>();
        // Lista que almacena las clases que se encuentran en esa sede
        ArrayList <String> nombreAsignaturas = new ArrayList<String>();
        // Se agregan las notas de la sede a la lista
        for (Usuario user : sede.getUsuarios()) {
            for (Asignatura asignatura : user.getAsignaturas()) {
                asignaturasSede.add(asignatura);
                if (!nombreAsignaturas.contains(asignatura.getNombre())){
                    nombreAsignaturas.add(asignatura.getNombre());
                }
            }
        }

        // Filtración de las asignaturas por el nombre y así obtener la nota mas alta y baja de cada curso
        for (String nombreAsignatura : nombreAsignaturas) {
            for (Asignatura asignaturaSede : asignaturasSede) {
                if (asignaturaSede.getNombre().equals(nombreAsignatura)){
                    notas.add(asignaturaSede.getNota());
                }
            }

            // Calculos para nota alta
            double notaAlta = notas.get(0);

            for (Double nota : notas) {
                if (nota > notaAlta){
                    notaAlta = nota;
                }
            }

            // Calculo para nota baja
            double notaBaja = notas.get(0);

            for (Double nota : notas) {
                if (nota < notaBaja){
                    notaBaja = nota;
                }
            }

            // Se muestra la información de las notas por clase.
            System.out.println("-------" + nombreAsignatura + "-------");
            System.out.println("Nota más alta: " + notaAlta);
            System.out.println("Nota más baja: " + notaBaja);
            System.out.println();
        }
        System.out.println();
    }

    /**
     * 
     * @param idSede parámetro que almacena el id de la sede en la cuál se estara trabajando.
     */
    public void cantidadAlumnos(){
        for (Sede sede : sedes) {
            System.out.println("La cantidad de alumnos registrados en la sede " + sede.getNombre() + " es de: " + sede.getUsuarios().size());        
        }
        System.out.println();
    }

}