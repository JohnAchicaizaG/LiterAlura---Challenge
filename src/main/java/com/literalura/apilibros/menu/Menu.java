package com.literalura.apilibros.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.literalura.apilibros.menu.Service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Menu {

    private final MenuService menuService;

    @Autowired
    public Menu(MenuService menuService) {
        this.menuService = menuService;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;

        while (option != 0) {
            printMenu();
            try {
                System.out.print("Selecciona una opción: ");
                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        System.out.print("Ingrese el título del libro: ");
                        String title = scanner.nextLine();
                        title = title.replace(" ", "+");
                        menuService.searchBookByTitle(title);
                        break;
                    case 2:
                        menuService.listRegisteredBooks();
                        break;
                    case 3:
                        menuService.listRegisteredAuthors();
                        break;
                    case 4:
                        menuService.listLivingAuthorsInYear();
                        break;
                    case 5:
                        System.out.println("Seleccione el idioma:");
                        System.out.println("1. Español");
                        System.out.println("2. Inglés");
                        System.out.print("Seleccione una opción: ");
                        int languageOption = scanner.nextInt();
                        scanner.nextLine();

                        String language;
                        if (languageOption == 1) {
                            language = "[es]";
                        } else if (languageOption == 2) {
                            language = "[en]";
                        } else {
                            System.out.println("Opción no válida");
                            continue;
                        }
                        menuService.listBooksByLanguage(language);
                        break;
                    case 6:
                        menuService.top10DownloadedBooks();
                        break;
                    case 0:
                        System.out.println("Salir");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, selecciona una opción del 0 al 7.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingresa un número.");
                scanner.next(); // Limpiar la entrada incorrecta
            }
        }

        scanner.close();
    }

    private void printMenu() {
        System.out.println("========================================================");
        System.out.println("|                   Menú de LiterAlura                 |");
        System.out.println("========================================================");
        System.out.println("| 1- Buscar libro por título                            |");
        System.out.println("| 2- Lista de libros registrados                        |");
        System.out.println("| 3- Lista de autores registrados                       |");
        System.out.println("| 4- Lista de autores vivos en  un año determinado      |");
        System.out.println("| 5- Lista de libros por idioma                         |");
        System.out.println("| 6- Top 10 libros más descargados                      |");
        System.out.println("| 0- Salir                                              |");
        System.out.println("========================================================");
    }
}
