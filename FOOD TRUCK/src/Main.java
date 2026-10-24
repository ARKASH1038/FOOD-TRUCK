import java.util.Scanner;

public class Main {

     //FoodTruckGoenagaExpress//  //DECLARACION Y ARREGLOS//

    static final int NUM_PRODUCTOS = 3;
    static final int NUM_TURNOS = 4;
    static final double META = 500000;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String[] productos = {"HAMBURGUESA", "PERRO CALIENTE", "PAPAS FRITAS"};
        String[] turnos = {"ALMUERZO", "TARDE", "NOCHE", "MADRUGADA"};
        double[][] ventas = new double[NUM_PRODUCTOS][NUM_TURNOS];
        double[] totProd = new double[NUM_PRODUCTOS];
        double[] totTurno = new double[NUM_TURNOS];
        double totGeneral;
        int seleccion;

        do {
            limpiarPantalla();
            System.out.println("BIENVENIDO A:");
            System.out.println("FOOD TRUCK GOENAGA EXPRESS");
            System.out.println("DIGITE EL NUMERO DE LA OPCION QUE LE CORRESPONDA:");
            System.out.println("1-TURNO ALMUERZO");
            System.out.println("2-TURNO TARDE");
            System.out.println("3-TURNO NOCHE");
            System.out.println("4-TURNO MADRUGADA");
            System.out.println("5-GENERAR REPORTE");
            seleccion = pedirOpcion(5);

            if (seleccion != 5) {
                registrarVenta(ventas, productos, seleccion - 1);
            } else {
                totalProducto(ventas, totProd);
                totalTurno(ventas, totTurno);
                totGeneral = totalGeneral(ventas);
                mostrarResultados(productos, turnos, totProd, totTurno, totGeneral);
            }
        } while (seleccion != 5);
    }

                                //METODO REGISTRAR VENTAS//

    static void limpiarPantalla() {

        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }

    static int pedirOpcion(int maximo) {
        int v;
        do {
            while (!sc.hasNextInt()) {
                sc.next();
            }
            v = sc.nextInt();
        } while (v < 1 || v > maximo);
        return v;
    }

    static double leerReal() {
        while (!sc.hasNextDouble()) {
            sc.next();
        }
        return sc.nextDouble();
    }

    static void registrarVenta(double[][] m, String[] nombres, int turno) {
        limpiarPantalla();
        System.out.println("SELECCIONE EL PRODUCTO:");
        for (int i = 0; i < NUM_PRODUCTOS; i++) {
            System.out.println((i + 1) + "-" + nombres[i]);
        }
        int p = pedirOpcion(NUM_PRODUCTOS) - 1;
        limpiarPantalla();
        m[p][turno] += validarNoNegativo("INGRESA EL TOTAL DE LAS VENTAS:");
    }
                                            //METODO VALIDACION//

    static double validarNoNegativo(String mensaje) {
        double v;
        System.out.println(mensaje);
        v = leerReal();
        while (v < 0) {
            System.out.println("Error: El valor no puede ser negativo. Intente de nuevo:");
            v = leerReal();
        }
        return v;
    }

                                                //METODO REPORTE//

    static void totalProducto(double[][] m, double[] vp) {
        for (int i = 0; i < NUM_PRODUCTOS; i++) {
            vp[i] = 0;
            for (int j = 0; j < NUM_TURNOS; j++) {
                vp[i] += m[i][j];
            }
        }
    }

    static void totalTurno(double[][] m, double[] vt) {
        for (int j = 0; j < NUM_TURNOS; j++) {
            vt[j] = 0;
            for (int i = 0; i < NUM_PRODUCTOS; i++) {
                vt[j] += m[i][j];
            }
        }
    }

    static double totalGeneral(double[][] m) {
        double t = 0;
        for (int i = 0; i < NUM_PRODUCTOS; i++) {
            for (int j = 0; j < NUM_TURNOS; j++) {
                t += m[i][j];
            }
        }
        return t;
    }

    static int buscarMayor(double[] v, int n) {
        int pos = 0;
        for (int k = 1; k < n; k++) {
            if (v[k] > v[pos]) {
                pos = k;
            }
        }
        return pos;
    }

    static int buscarMenor(double[] v, int n) {
        int pos = 0;
        for (int k = 1; k < n; k++) {
            if (v[k] < v[pos]) {
                pos = k;
            }
        }
        return pos;
    }

    static void mostrarResultados(String[] nombres, String[] turnos, double[] vp, double[] vt, double total) {
        limpiarPantalla();
        System.out.println("REPORTE:");
        for (int i = 0; i < NUM_PRODUCTOS; i++) {
            System.out.println(nombres[i] + ": $" + formato(vp[i]));
        }
        for (int i = 0; i < NUM_TURNOS; i++) {
            System.out.println(turnos[i] + ": $" + formato(vt[i]));
        }
        int a = buscarMayor(vp, NUM_PRODUCTOS);
        int b = buscarMenor(vp, NUM_PRODUCTOS);
        int c = buscarMayor(vt, NUM_TURNOS);
        int d = buscarMenor(vt, NUM_TURNOS);
        System.out.println("Producto mayor: " + nombres[a] + " $" + formato(vp[a]));
        System.out.println("Producto menor: " + nombres[b] + " $" + formato(vp[b]));
        System.out.println("Turno mayor: " + turnos[c] + " $" + formato(vt[c]));
        System.out.println("Turno menor: " + turnos[d] + " $" + formato(vt[d]));
        System.out.println("TOTAL GENERAL RECAUDADO: $" + formato(total));
        if (total > META) {
            System.out.println("Meta de Ventas Alcanzada");
        } else {
            System.out.println("Meta No Alcanzada");
        }
    }

    static String formato(double valor) {
        if (valor == Math.floor(valor)) {
            return String.valueOf((long) valor);
        }
        return String.valueOf(valor);
    }
}