package act1.yesno;

import java.util.Scanner;

public class Game {
	
	//Originalmente basada en la clase BTree de los ejercicios de Oracle, pero a lo largo del proyecto quedó muy distinta. Me deshice de casí
	//todo lo que tenía y agregué varias cosas nuevas.
	
    private Node root; // Sigue con el nodo root
    private int won; // Lleva contadores de los juegos ganados y perdidos
    private int lost;

    public Game() {
    	// El constructor del juego empieza con una sola pregunta y 2 posibles respuestas. Dada la manera en la que van creciendo
    	// sus preguntas, no sería necesario darle más. Incluso le basta empezar con una sóla respuesta.
        root = new Node("¿Caza ratones?");
        root.left = new Node("R: gato");
        root.right = new Node("R: perro");
        won = 0;
        lost = 0;
    }

    public void playGame() {
        root = playGame(root);
    }
    
    // Este es el método mas importante de todos. Donde realmente ocurre todo.

    private Node playGame(Node node) {
        Scanner playerInput = new Scanner(System.in); // Se utiliza la clase scanner para leer lo que ingresa el jugador
		if (node.question.contains("R: ")) { // Si la "pregunta" empieza con R: (es decir, es una respuesta)
		    System.out.println("¿Es un " + node.question.substring(3) + "? s/n");
		    String finalAnswer = playerInput.nextLine(); // Aquí el jugador da el si/no final
		    
		    if (finalAnswer.charAt(0) == 's' || finalAnswer.charAt(0) == 'S') {
		        System.out.println("¡Gané! Soy el mejor! El mejor!");
		        won++;
		    } else {
		        System.out.println("¡Perdí! Pero la proxima seré más listo, jeje!");
		        lost++;
		        
		        // Aquí el jugador le va a dar la respuesta correcta y una pregunta buena para el futuro a la maquina
		        System.out.println("¿Cuál era tu animal?");
		        String correctAnswer = "R: " + playerInput.nextLine();

		        System.out.println("¿Qué pregunta podría haber distinguido entre " +
		                node.question.substring(3) + " y " + correctAnswer.substring(3) + "?");
		        String goodQuestion = playerInput.nextLine();

		        System.out.println("Y para " + correctAnswer.substring(3) + ", ¿esa pregunta se responde con sí, o con no? s/n");
		        char yesNo = playerInput.nextLine().charAt(0);
		        if (yesNo == 's' || yesNo == 'S') {
		            node = new Node(goodQuestion, new Node(correctAnswer), node); // Si la pregunta es afirmativa, se almacena la respuesta a
		        } else {														  // la izquierda del nuevo nodo
		            node = new Node(goodQuestion, node, new Node(correctAnswer)); // Sino, a la derecha
		        }
		    }
		} else { // Cuando es una pregunta normal
		    System.out.println(node.question + " s/n");
		    String respuestaSiNo = playerInput.nextLine();

		    if (respuestaSiNo.charAt(0) == 's' || respuestaSiNo.charAt(0) == 'S') {
		        node.left = playGame(node.left); // Se utiliza recursión para guardar el nuevo nodo, el cual se obtiene del siguiente playGame
		    } else {
		        node.right = playGame(node.right);
		    }
		}

        return node;
    }
    
    // Ganadas, perdidas, y el print

    public int getWon() {
        return won;
    }

    public int getLost() {
        return lost;
    }

    public void print() {
        this.root.print();
    }
}
