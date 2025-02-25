package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int moneda20 = 0, moneda50 = 0 , moneda100 = 0, moneda200 = 0, moneda500 = 0, total = 0, opcion;
        boolean saliendo = true;

        do {
            System.out.println("Seleccione una opcion:");
            System.out.println("1. Agregar moneda");
            System.out.println("2. Contar monedas");
            System.out.println("3. Calcular total ahorrado");
            System.out.println("4. Romper alcancía");
            System.out.println("5. Salir\n");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la denominación de la moneda (20, 50, 100, 200, 500):\n");
                    int denominacion = scanner.nextInt();
                    switch (denominacion) {
                        case 20:
                            moneda20++;
                            break;
                        case 50:
                            moneda50++;
                            break;
                        case 100:
                            moneda100++;
                            break;
                        case 200:
                            moneda200++;
                            break;
                        case 500:
                            moneda500++;
                            break;
                        default:
                            System.out.println("Denominacion no valida.");
                    }
                    break;
                case 2:
                    System.out.println("$20 - Cantidad: " + moneda20  + " - Total: " + moneda20 * 20);
                    System.out.println("$50 - Cantidad: " + moneda50  + " - Total: " + moneda50 * 50);
                    System.out.println("$100 - Cantidad: " + moneda100 + " - Total: " + moneda100 * 100);
                    System.out.println("$200 - Cantidad: " + moneda200  + " - Total: " + moneda200 * 200);
                    System.out.println("$500 - Cantidad: " + moneda500  + " - Total: " + moneda500 * 500 + "\n");
                    break;
                case 3:
                    total = (moneda20 * 20) + (moneda50 * 50) + (moneda100 * 100) + (moneda200 * 200) + (moneda500 * 500);
                    System.out.println("Total ahorrado: $" + total + "\n");
                    break;
                case 4:
                    moneda20 = 0; moneda50 = 0; moneda100 = 0; moneda200 = 0; moneda500 = 0; total = 0;
                    System.out.println("La alcancia ha sido rota y vaciada." + "\n");
                    break;
                case 5:
                    saliendo = false;
                    System.out.println("Saliendo... 🫡");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (saliendo);

        scanner.close();
    }
}