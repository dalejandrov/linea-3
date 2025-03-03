package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int costoInternet = 700000;
        final int costoRadio = 200000;
        final int costoTelevision = 600000;

        int[] votos = new int[3];
        int[] votosInternet = new int[3];
        int[] votosRadio = new int[3];
        int[] votosTelevision = new int[3];
        int opcion;

        do {
            System.out.println("\n--- Elecciones Premier ---");
            System.out.println("1. Votar");
            System.out.println("2. Calcular costo de campaña");
            System.out.println("3. Vaciar todas las urnas");
            System.out.println("4. Mostrar número total de votos");
            System.out.println("5. Mostrar porcentaje de votos por candidato");
            System.out.println("6. Mostrar costo promedio de campaña");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\nSeleccione un candidato (1, 2 o 3): ");
                    int candidato = scanner.nextInt() - 1;
                    if (candidato < 0 || candidato >= 3) {
                        System.out.println("Candidato no válido.");
                        break;
                    }

                    System.out.println("Seleccione el medio de influencia: ");
                    System.out.println("1. Internet");
                    System.out.println("2. Radio");
                    System.out.println("3. Televisión");
                    int medio = scanner.nextInt();

                    votos[candidato]++;
                    switch (medio) {
                        case 1:
                            votosInternet[candidato]++;
                            break;
                        case 2:
                            votosRadio[candidato]++;
                            break;
                        case 3:
                            votosTelevision[candidato]++;
                            break;
                        default:
                            System.out.println("Medio no válido. Voto no registrado.");
                            votos[candidato]--;
                    }
                    break;
                case 2:
                    for (int i = 0; i < 3; i++) {
                        int costo = (votosInternet[i] * costoInternet) + (votosRadio[i] * costoRadio) + (votosTelevision[i] * costoTelevision);
                        System.out.println("Costo de campaña del Candidato " + (i + 1) + ": $" + costo);
                    }
                    break;
                case 3:
                    for (int i = 0; i < 3; i++) {
                        votos[i] = votosInternet[i] = votosRadio[i] = votosTelevision[i] = 0;
                    }
                    System.out.println("Todas las urnas han sido vaciadas.");
                    break;
                case 4:
                    int total = 0;
                    for (int v : votos) total += v;
                    System.out.println("Total de votos: " + total);
                    break;
                case 5:
                    total = 0;
                    for (int v : votos) total += v;
                    if (total == 0) {
                        System.out.println("No hay votos registrados.");
                        break;
                    }
                    for (int i = 0; i < 3; i++) {
                        double porcentaje = ((double) votos[i] / total) * 100;
                        System.out.printf("Candidato %d: %.2f%% de los votos.\n", i + 1, porcentaje);
                    }
                    break;
                case 6:
                    int totalCostos = 0, totalCandidatos = 0;
                    for (int i = 0; i < 3; i++) {
                        int costo = (votosInternet[i] * costoInternet) + (votosRadio[i] * costoRadio) + (votosTelevision[i] * costoTelevision);
                        if (votos[i] > 0) {
                            totalCostos += costo;
                            totalCandidatos++;
                        }
                    }
                    if (totalCandidatos == 0) {
                        System.out.println("No hay votos registrados, costo promedio es $0.");
                        break;
                    }
                    System.out.println("Costo promedio de campaña: $" + (totalCostos / totalCandidatos));
                    break;
                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 7);

        scanner.close();
    }
}
