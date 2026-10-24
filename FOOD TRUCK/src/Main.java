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
    }



}