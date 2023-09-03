/**
 * - Clase que posee el método main, lo cual permite ser el archivo de arranque del programa.
 * - El sistema trabaja con arreglos dinámicos.
 * 
 * - El sistema creado permite la gestión de las distintas sedes de una unirversidad, asimismo permite tener el control de su estudiantes,
 *   también se puede visualizar la media, mediana, moda y desviación estándar. Es importante mencionar se podrá visualizar las notas más altas y bajas
 *   por asignatura en cada sede.
 * 
 * - Como método defensivo el sistema cuenta con un sistema de validación de entrada de datos lo cuál verifica que no se puedan ingresar caracteres en los campos
 *   donde se solicita valores enteros.
 * 
 * - Menú principal:
 *      1.	Creación de sede.
        2.	Seleccionar la sede en la que se estará trabajando.
        3.	Salir.
    
* - Sub menú:
        1.	Agregar estudiante.
        2.	Establecer nota a estudiante
        3.	Mostrar análisis estadístico sede.
        4.	Cantidad de alumnos por sede.
        5.	Nota más alta y más baja de los exámenes de la sede.
        6.	Regresar menú principal.

* - Como dato importante se utilizacon las siguientes librerias para poder resolver el problema planteado. :
    
    MANEJO DE FECHAS:
    - java.text.ParseException
    - java.text.SimpleDateFormat
    - java.util.Date

    MANEJO DE FRECUENCIA DE DATOS PARA LA MODA
    - java.util.HashMap
    - java.util.Map
    - java.util.Map.Entry

    PARA ORDENAR EL ARRAYLIST POR MEDIO DE DEL MÉTODO DE COLLECTIONS (Sort)
    - java.util.Collections

* - @author Jose Ruiz
* - @version 1.0
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        // Variables de clase
        Scanner sc = new Scanner(System.in);
        Universidad universidad = new Universidad("Universidad Del Valle");
        int opcion = 0;
        boolean continueProgram = true;

        // Loop que controla el flujo del programa
        while(continueProgram){
            try {
                Menu();
                opcion = sc.nextInt();
                if (opcion == 1){ // Creación de sede.
                    // Ingreso de datos
                    System.out.println("Ingrese el ID de la sede. ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese el nombre de la sede. ");
                    String nombre = sc.nextLine();
                    // Creación de instancia sede
                    Sede sede = new Sede(id, nombre);

                    // Se agrega la sede a la lista de sedes de la universidad.
                    universidad.agregarSede(sede);
                    // Se imprime la sede ingresada
                    System.out.println();
                    System.out.println("¡Sede agregada exitosamente! ");

                }else if(opcion == 2){ // Seleccionar la sede en la que se estará trabajando.
                    System.out.println();
                    System.out.println("Seleccione la sede en la cuál desea trabajar: ");
                    universidad.mostrarSedes();
                    int indiceArraySede = sc.nextInt();
                    // Se indica en que sede se estará trabajando.
                    universidad.controlSede(indiceArraySede);


                }else if (opcion == 3){ // Salir
                    System.out.println("Gracias por usar el programa.");
                    continueProgram = false;

                }else{
                    System.out.println("Opción no disponible, ingrese una opción válida.");

                }
            } catch (InputMismatchException e) { 
                System.out.println("Entrada inválida, debe ingresar un número entero.");
                sc.nextLine();
            }
            
        }

    }

    /**
     * Método que muestra el menu del programa.
     */
    public static void Menu(){
        System.out.println("--------------------------------------");
        System.out.println("1. Crear sede.");
        System.out.println("2. Selección de sede. ");
        System.out.println("3. Salir");
        System.out.println("--------------------------------------");
    }

}