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

    // ====== PUNTO 1: Registrar nuevo préstamo (María Tamara) ======
    static void registrarPrestamo() {
        System.out.println("==== Registrar nuevo préstamo ====");
        int id = leerEntero("Ingrese el ID: ");
        String usuario = leerTexto("Ingrese el nombre del usuario: ");
        String libro = leerTexto("Ingrese el título del libro: ");
        int dias = leerEntero("Digite los días de préstamo: ");
        int multa = leerEntero("Multa por día: ");

        ArrayList<Object> prestamo = new ArrayList<>();
        prestamo.add(id);
        prestamo.add(usuario);
        prestamo.add(libro);
        prestamo.add(dias);
        prestamo.add(multa);

        prestamos.add(prestamo);

        System.out.println("El préstamo ha sido registrado :)");
    }

    // ====== PUNTO 2: Mostrar todos los préstamos 
    static void mostrarPrestamos() {
        if (prestamos.isEmpty()) {
            System.out.println("No hay préstamos registrados.");
            return;
        }

        System.out.println("\n=== Lista de todos los préstamos ===");
        for (ArrayList<Object> p : prestamos) {
            if (p == null || p.size() < 5) continue;
            System.out.println("------------------------");
            System.out.println("ID: " + p.get(0));
            System.out.println("Usuario: " + p.get(1));
            System.out.println("Libro: " + p.get(2));
            System.out.println("Días: " + p.get(3));
            System.out.println("Multa/día: $" + p.get(4));
        }
        System.out.println("------------------------");
    }

    // ====== PUNTO 3: Buscar préstamo por ID (María Tamara) ======
    static void buscarPrestamoPorId() {
        System.out.println("==== Buscar préstamo por ID ====");
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
            System.out.println("No se encontró un préstamo con ese ID.");
        }
    }

    // ====== PUNTO 4: Actualizar un préstamo (Samuel Ortega) ======
    static void actualizarPrestamo() {
        System.out.println("==== Actualizar préstamo ====");
        int id = leerEntero("Ingrese ID del préstamo a actualizar: ");
        
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
            System.out.println("Préstamo no encontrado.");
            return;
        }
        
        System.out.println("\nDatos actuales:");
        System.out.println("ID: " + prestamo.get(0));
        System.out.println("Usuario: " + prestamo.get(1));
        System.out.println("Libro: " + prestamo.get(2));
        System.out.println("Días: " + prestamo.get(3));
        System.out.println("Multa/día: $" + prestamo.get(4));
        
        System.out.println("\n¿Qué desea actualizar?");
        System.out.println("1. Nombre del usuario");
        System.out.println("2. Título del libro");
        System.out.println("3. Días de préstamo");
        System.out.println("4. Multa por día");
        System.out.println("5. Cancelar");
        
        int opcion = leerEntero("Seleccione opción: ");
        
        if (opcion == 1) {
            String nuevoNombre = leerTexto("Nuevo nombre de usuario: ");
            prestamo.set(1, nuevoNombre);
            System.out.println("Usuario actualizado correctamente.");
        } 
        else if (opcion == 2) {
            String nuevoTitulo = leerTexto("Nuevo título del libro: ");
            prestamo.set(2, nuevoTitulo);
            System.out.println("Título actualizado correctamente.");
        } 
        else if (opcion == 3) {
            int nuevosDias = leerEntero("Nuevos días de préstamo: ");
            prestamo.set(3, nuevosDias);
            System.out.println("Días actualizados correctamente.");
        } 
        else if (opcion == 4) {
            int nuevaMulta = leerEntero("Nueva multa por día: ");
            prestamo.set(4, nuevaMulta);
            System.out.println("Multa actualizada correctamente.");
        } 
        else if (opcion == 5) {
            System.out.println("Actualización cancelada.");
        } 
        else {
            System.out.println("Opción inválida.");
        }
    }

    // ====== PUNTO 5: Eliminar un préstamo (Moisés Romero) ======
    static void eliminarPrestamo() {
        System.out.println("==== Eliminar préstamo ====");
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
                System.out.println("Préstamo con ID " + id + " eliminado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró un préstamo con ID " + id + ".");
    }

    // ====== PUNTO 6: Calcular total de multas (Moisés Romero) ======
    static void calcularTotalMultas() {
        System.out.println("==== Calcular total de multas ====");
        
        if (prestamos.isEmpty()) {
            System.out.println("No hay préstamos registrados.");
            return;
        }
        
        int totalMultas = 0;
        
        System.out.println("\nDetalle de multas:");
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
            
            int multaIndividual = diasPrestamo * multaPorDia;
            totalMultas += multaIndividual;
            
            System.out.println("- " + p.get(1) + " (" + p.get(2) + "): " + 
                             diasPrestamo + " días × $" + multaPorDia + " = $" + multaIndividual);
        }
        
        System.out.println("\n========================");
        System.out.println("TOTAL DE MULTAS: $" + totalMultas);
        System.out.println("========================");
    }

    // ====== Utilidades ======
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