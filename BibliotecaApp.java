import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    // prestamo = [idPrestamo, nombreUsuario, tituloLibro, diasPrestamo, multaPorDia]
    static ArrayList<ArrayList<Object>> prestamos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                 registrarPrestamo();
                 break;
                case 2:
                     mostrarPrestamos();
                     break;
                case 3:
                     buscarPrestamoPorId();
                     break;
                case 4:
                     actualizarPrestamo();
                     break;
                case 5:
                     eliminarPrestamo();
                     break;
                case 6:
                     calcularTotalMultas();
                     break;
                case 7:
                     System.out.println("Saliendo...");
                     break;
                default: System.out.println("Opción inválida.");
                break;
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

    // ====== CRUD (ya casi) ======
    static void registrarPrestamo() {
    int id = leerEntero("Ingrese el ID: ");
    String usuario = leerTexto("Ingrese el nombre del usuario: ");
    String libro = leerTexto("Ingrese el título del libro: ");
    int dias = leerEntero("Digite los días de préstamo: ");
    double multa = Double.parseDouble(leerTexto("Multa por día: "));

    ArrayList<Object> prestamo = new ArrayList<>();
    prestamo.add(id);
    prestamo.add(usuario);
    prestamo.add(libro);
    prestamo.add(dias);
    prestamo.add(multa);

    prestamos.add(prestamo);

    System.out.println("El préstamo ha sido registrado :)");
}

 static void mostrarPrestamos(){//Todo//};
static void buscarPrestamoPorId() {
    int idBuscado = leerEntero("Ingrese el ID del préstamo a buscar: ");
    boolean encontrado = false;

    for (ArrayList<Object> p : prestamos) {
        int id = (int) p.get(0);

        if (id == idBuscado) {
            System.out.println("=== Préstamo encontrado ===");
            System.out.println("ID: " + p.get(0));
            System.out.println("Usuario: " + p.get(1));
            System.out.println("Libro: " + p.get(2));
            System.out.println("Días: " + p.get(3));
            System.out.println("Multa por día: " + p.get(4));
            encontrado = true;
            break;
        }
    }

    if (!encontrado) {
        System.out.println("No se encontró un préstamo con ese ID xd.");
    }
}


    static void actualizarPrestamo() { /* TODO */ }
    static void eliminarPrestamo() { /* TODO */ }

    // ====== Cálculo (por implementar) ======
    static void calcularTotalMultas() { /* TODO */ }

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