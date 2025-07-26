package act1.yesno;

import java.util.Scanner;

public class YesNoGame {
    public static void main(String[] args) {
        Game newGame = new Game();
        Scanner scanner = new Scanner(System.in);
        boolean keepPlaying = true;
        
        System.out.println("¡Bienvenid@ al Yes/No Game, donde voy a adivinar un animal, "
        		+ "me dirás si me equivoco o no, y, si eres honest@, me harás cada vez más inteligente!");

        while (keepPlaying) {
        	// Este es el menu interactivo de linea de comandos
            System.out.println("\nTus Opciones:");
            System.out.println("1. Jugar");
            System.out.println("2. Ver árbol actual");
            System.out.println("3. Salir");

            System.out.print("Elige una: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    // Jugar
                    newGame.playGame();
                    // Mostrar estadísticas del juego después de jugar
                    System.out.println("\nHe ganado: " + newGame.getWon());
                    System.out.println("He perdido: " + newGame.getLost());
                    break;
                case "2":
                    // Mostrar el árbol
                    System.out.println("\nMira, esto es lo que he aprendido hasta el momento:\n");
                    newGame.print();
                    break;
                case "3":
                    // Salir del juego
                    keepPlaying = false;
                    break;
                default:
                    System.out.println("No te dije que le dieras a ese número. Intenta con las otras opciones");
                    break;
            }
        }

        System.out.println("¡No, espera! 'Me harás tonto otra vez! NOOOO!!!");
    }
}
