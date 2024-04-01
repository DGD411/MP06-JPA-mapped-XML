package SchoolHiberJPA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    private int option;

    public Menu() {
        super();
    }

    public int menuPral() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {

            System.out.println(" \nMENU PRINCIPAL \n");

            System.out.println("1. Mostrar departamentos. ");
            System.out.println("2. Mostrar grupos. ");
            System.out.println("3. Mostrar sessions. ");
            System.out.println("4. Mostrar materias. ");
            System.out.println("5. Mostrar profesores. ");
            System.out.println("6. Cargar datos. ");

            System.out.println("0. Sortir. ");

            System.out.println("Esculli opció: ");
            try {
                option = Integer.parseInt(br.readLine());
            } catch (NumberFormatException | IOException e) {
                System.out.println("valor no vàlid");
                e.printStackTrace();
            }
        } while (option != 1  && option != 0);

        return option;
    }

}