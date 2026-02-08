import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    // prestamo = [idPrestamo, nombreUsuario, tituloLibro, diasPrestamo,
    // multaPorDia]
    static ArrayList<ArrayList<Object>> prestamos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1 -> registrarPrestamo();
                case 2 -> mostrarPrestamos();
                case 3 -> buscarPrestamoPorId();
                case 4 -> actualizarPrestamo();
                case 5 -> eliminarPrestamo();
                case 6 -> calcularTotalMultas();
                case 7 -> {
                    System.out.println("======================");
                    System.out.println("Gracias por utilizar nuestro menú");
                    System.out.println("Realizado por Samuel Ortega");
                    System.out.println("======================");
                }
                default -> System.out.println("Opción inválida.");
            }
            System.out.println();
        } while (opcion != 7);

        sc.close();
    }

    static void mostrarMenu() {
        System.out.println("=== Biblioteca: Gestión de Préstamos ===");
        System.out.println("1. Registrar nuevo préstamo");
        System.out.println("2. Mostrar todos los préstamos");
        System.out.println("3. Buscar préstamo por ID");
        System.out.println("4. Actualizar un préstamo");
        System.out.println("5. Eliminar un préstamo");
        System.out.println("6. Calcular total de multas");
        System.out.println("7. Salir");
    }

    // ====== CRUD (por implementar) ======
    static void registrarPrestamo() {
        /* TODO */ }

    static void mostrarPrestamos() {
        /* TODO */ }

    static void buscarPrestamoPorId() {
        /* TODO */ }

    static void actualizarPrestamo() {
    System.out.println("==== Actualizar prestamo ====");
    int id = leerEntero("Ingrese ID edl prestamo a actualizar: ");
    
    ArrayList<Object> prestamo = null;
    boolean encontrado = false;
    
    for (int i = 0; i < prestamos.size(); i++) {
        ArrayList<Object> p = prestamos.get(i);
        int idPrestamo = (int) p.get(0);
        
        if (idPrestamo == id) {
            prestamo = p;
            encontrado = true;
            break;
        }
    }
    
    if (encontrado == false) {
        System.out.println("Prestamo no encontrado.");
        return;
    }
    
    System.out.println("\nDatos actuales:");
    System.out.println("ID: " + prestamo.get(0));
    System.out.println("Usuario: " + prestamo.get(1));
    System.out.println("Libro: " + prestamo.get(2));
    System.out.println("Dias: " + prestamo.get(3));
    System.out.println("Multa/dia: $" + prestamo.get(4));
    
    System.out.println("\nQue desea actualizar?");
    System.out.println("1. Nombre del usuario");
    System.out.println("2. Titulo del libro");
    System.out.println("3. Dias de prestamo");
    System.out.println("4. Multa por dia");
    System.out.println("5. Cancelar");
    
    int opcion = leerEntero("Seleccione opcion: ");
    
    if (opcion == 1) {
        String nuevoNombre = leerTexto("Nuevo nombre de usuario: ");
        prestamo.set(1, nuevoNombre);
        System.out.println("Usuario actualizado correctamente.");
    } 
    else if (opcion == 2) {
        String nuevoTitulo = leerTexto("Nuevo titulo del libro: ");
        prestamo.set(2, nuevoTitulo);
        System.out.println("Titulo actualizado correctamente.");
    } 
    else if (opcion == 3) {
        int nuevosDias = leerEntero("Nuevos dias de prestamo: ");
        prestamo.set(3, nuevosDias);
        System.out.println("Dias actualizados correctamente.");
    } 
    else if (opcion == 4) {
        int nuevaMulta = leerEntero("Nueva multa por dia: ");
        prestamo.set(4, nuevaMulta);
        System.out.println("Multa actualizada correctamente.");
    } 
    else if (opcion == 5) {
        System.out.println("Actualizacion cancelada.");
    } 
    else {
        System.out.println("Opcion invalida.");
    }

    static void eliminarPrestamo() {
        /* TODO */ }

    // ====== Cálculo (por implementar) ======
    static void calcularTotalMultas() {
        /* TODO */ }

    // ====== Utilidades mínimas ======
    static int leerEntero(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Ingrese un entero válido.");
            }
        }
    }

    static String leerTexto(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }
}