import materia.controllers.BinaryTree;

public class App {
    public static void main(String[] args) throws Exception {
        BinaryTree ab = new BinaryTree();
        ab.insert(50);
        ab.insert(17);
        ab.insert(76);
        ab.insert(9);
        ab.insert(23);
        ab.insert(54);
        ab.insert(14);
        ab.insert(19);
        System.out.print("PreOrder: ");
        ab.printPreorder();

        System.out.print("\nPostOrder: ");
        ab.printPosOrder();

        System.out.print("\nInOrder: ");
        ab.printInOrder();
    }
}