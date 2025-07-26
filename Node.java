package act1.yesno;

public class Node {
	//La clase nodo adaptada para el juego. En su mayoría, completamente igual a como quedó despues de los
	//Ejercicios de Oracle. Solo se borraron metodos que no aplicaban (sobre todo los prints en cierto orden)
	//Y se agregó un constructor para crear el nodo con sus hijos de manera inmediata.
	
	String question;
	Node left;
	Node right;
	
	Node(String question) {
		this.question = question;
		this.left = null;
		this.right = null;
	}
	
	Node(String question, Node left, Node right){
		this.question = question;
		this.left = left;
		this.right = right;
	}
	
	void setLeft(Node node) {
		if(this.left == null)
			this.left = node;
	}
	
	void setRight(Node node) {
		if(this.right == null)
			this.right = node;
	}
	
	Node getLeft() {
		return this.left;
	}
	
	Node getRight() {
		return this.right;
	}
	
	void setQuestion(String question) {
		this.question = question;
	}
	
	String getQuestion() {
		return this.question;
	}
	
	
	public String print() {
		return this.print("", true ,"");
	}
	
	// Se modificó ligeramente el print de los ejercicios de Oracle para que rastreé S/N.
	public String print(String prefix, boolean isTail, String sb) {
		if (right != null) {
			right.print(prefix + (isTail ? "|   " : "    "), false, sb);
		}
		
		System.out.println( prefix+(isTail ? "S-- " : "N-- ") + question);
		
		if (left != null) {
			left.print(prefix+(isTail ? "    " : "|   "), true, sb);
		}
		return sb;
	}
}
