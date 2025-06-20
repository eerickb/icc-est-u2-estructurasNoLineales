import materia.controllers.BinaryTree;

public class App {
    public static void main(String[] args) {
        System.out.println("Nombre: Erick Bermeo");

        BinaryTree ab = new BinaryTree();
        ab.insert(50);
        ab.insert(17);
        ab.insert(76);
        ab.insert(9);
        ab.insert(23);
        ab.insert(54);
        ab.insert(14);
        ab.insert(19);

        System.out.println("\nPeso del arbol = " + ab.peso());
        System.out.println("Altura es = " + ab.altura());

        System.out.println("\nArbol InOrder");
        ab.inOrder();

        System.out.println("\nArbol InOrder con alturas");
        ab.inOrderAlturas();

        System.out.println("\nArbol InOrder con factor de equilibrio");
        ab.inOrderBalance();

        System.out.println("\nArbol esta equilibrado = " + ab.estaBalanceado());

        System.out.println("Existe el nodo 15= " + ab.findeValue(15));

        System.out.println("Agregamos valor = 15");
        ab.insert(15);

        System.out.println("Arbol esta equilibrado = " + ab.estaBalanceado());

        System.out.println("\nArbol InOrder con factor de equilibrio");
        ab.inOrderBalance();

        System.out.print("Nodos desequilibrados ");
        ab.nodosDesequilibrados();
    }
}