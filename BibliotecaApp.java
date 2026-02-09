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
                case 1 -> registrarPrestamo();
                case 2 -> mostrarPrestamos();
                case 3 -> buscarPrestamoPorId();
                case 4 -> actualizarPrestamo();
                case 5 -> eliminarPrestamo();
                    //Eliminar un préstamo de la lista usando su ID.
                case 6 -> calcularTotalMultas();
                    //Calcular y mostrar el total estimado de multas:
                    //diasPrestamo × multaPorDia
                case 7 -> System.out.println("Saliendo...");
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
    static void registrarPrestamo() { /* TODO */ }
    static void mostrarPrestamos() { /* TODO */ }
    static void buscarPrestamoPorId() { /* TODO */ }
    static void actualizarPrestamo() { /* TODO */ }

    static void eliminarPrestamo() {
        int id = leerEntero("Ingrese el ID del préstamo a eliminar: ");
        for (int i = 0; i < prestamos.size(); i++) {
            ArrayList<Object> p = prestamos.get(i);
            if (p == null || p.isEmpty()) continue;
            Object idObj = p.get(0);
            int idPrestamo;
            if (idObj instanceof Integer) {
                idPrestamo = (Integer) idObj;
            } else {
                try {
                    idPrestamo = Integer.parseInt(idObj.toString());
                } catch (Exception e) {
                    continue;
                }
            }
            if (idPrestamo == id) {
                prestamos.remove(i);
                System.out.println("Préstamo con ID " + id + " eliminado.");
                return;
            }
        }
        System.out.println("No se encontró un préstamo con ID " + id + ".");
    }

    // ====== Cálculo (por implementar) ======
    static void calcularTotalMultas() { 
        int totalMultas = 0;
        for (ArrayList<Object> p : prestamos) {
            if (p == null || p.size() < 5) continue;
            Object diasObj = p.get(3);
            Object multaObj = p.get(4);
            int diasPrestamo, multaPorDia;
            try {
                diasPrestamo = Integer.parseInt(diasObj.toString());
                multaPorDia = Integer.parseInt(multaObj.toString());
            } catch (Exception e) {
                continue;
            }
            totalMultas += diasPrestamo * multaPorDia;
        }
        System.out.println("Total estimado de multas: " + totalMultas);
     }
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