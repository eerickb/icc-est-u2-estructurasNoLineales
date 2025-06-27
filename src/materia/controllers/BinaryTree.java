package materia.controllers;
import materia.models.Node;

public class BinaryTree {
    private Node root;
    private int count = 0;
    private boolean balanceado = true;

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node node, int value) {
        if (node == null) {
            count++;
            return new Node(value);
        }
        if (value <= node.getvalue())
            node.setLeft(insertRec(node.getLeft(), value));
        else
            node.setRight(insertRec(node.getRight(), value));
        return node;
    }

    public boolean findeValue(int value) {
        return buscar(root, value);
    }

    private boolean buscar(Node node, int value) {
        if (node == null) return false;
        if (node.getvalue() == value) return true;
        return value < node.getvalue() ? buscar(node.getLeft(), value) : buscar(node.getRight(), value);
    }

    public int peso() {
        return count;
    }

    public int altura() {
        return altura(root);
    }

    private int altura(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(altura(node.getLeft()), altura(node.getRight()));
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getvalue() + ", ");
            inOrder(node.getRight());
        }
    }

    public void inOrderAlturas() {
        inOrderAlturas(root);
        System.out.println();
    }

    private void inOrderAlturas(Node node) {
        if (node != null) {
            inOrderAlturas(node.getLeft());
            System.out.print(node.getvalue() + "(h=" + altura(node) + "), ");
            inOrderAlturas(node.getRight());
        }
    }

    public void inOrderBalance() {
        balanceado = true;
        inOrderBalance(root);
        System.out.println();
    }

    private void inOrderBalance(Node node) {
        if (node != null) {
            inOrderBalance(node.getLeft());
            int bf = altura(node.getLeft()) - altura(node.getRight());
            System.out.print(node.getvalue() + "(bf=" + bf + "), ");
            if (Math.abs(bf) > 1) balanceado = false;
            inOrderBalance(node.getRight());
        }
    }

    public boolean estaBalanceado() {
        balanceado = true;
        checkBalance(root);
        return balanceado;
    }

    private void checkBalance(Node node) {
        if (node != null) {
            int bf = altura(node.getLeft()) - altura(node.getRight());
            if (Math.abs(bf) > 1) balanceado = false;
            checkBalance(node.getLeft());
            checkBalance(node.getRight());
        }
    }

    public void nodosDesequilibrados() {
        int[] contador = {0};
        nodosDesequilibrados(root, contador);
        System.out.println();
    }

    private void nodosDesequilibrados(Node node, int[] contador) {
        if (node != null) {
            nodosDesequilibrados(node.getLeft(), contador);
            int bf = altura(node.getLeft()) - altura(node.getRight());
            if (Math.abs(bf) > 1) {
                if (contador[0] > 0) System.out.print(" y ");
                System.out.print(node.getvalue() + "(fE = " + bf + ")");
                contador[0]++;
            }
            nodosDesequilibrados(node.getRight(), contador);
        }
    }
}