package materia.controllers;
import materia.models.Node;

public class BinaryTree {
    private Node root;
    private int count = 0;
    private boolean balanceado = true;

    public void insert(int val) {
        root = insertRec(root, val);
    }

    private Node insertRec(Node n, int val) {
        if (n == null) {
            count++;
            return new Node(val);
        }
        if (val <= n.getvalue())
            n.setLeft(insertRec(n.getLeft(), val));
        else
            n.setRight(insertRec(n.getRight(), val));
        return n;
    }

    public boolean findeValue(int val) {
        return buscar(root, val);
    }

    private boolean buscar(Node n, int val) {
        if (n == null) return false;
        if (n.getvalue() == val) return true;
        return val < n.getvalue() ? buscar(n.getLeft(), val) : buscar(n.getRight(), val);
    }

    public int peso() {
        return count;
    }

    public int altura() {
        return altura(root);
    }

    private int altura(Node n) {
        if (n == null) return 0;
        return 1 + Math.max(altura(n.getLeft()), altura(n.getRight()));
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node n) {
        if (n != null) {
            inOrder(n.getLeft());
            System.out.print(n.getvalue() + ", ");
            inOrder(n.getRight());
        }
    }

    public void inOrderAlturas() {
        inOrderAlturas(root);
        System.out.println();
    }

    private void inOrderAlturas(Node n) {
        if (n != null) {
            inOrderAlturas(n.getLeft());
            System.out.print(n.getvalue() + "(h=" + altura(n) + "), ");
            inOrderAlturas(n.getRight());
        }
    }

    public void inOrderBalance() {
        balanceado = true;
        inOrderBalance(root);
        System.out.println();
    }

    private void inOrderBalance(Node n) {
        if (n != null) {
            inOrderBalance(n.getLeft());
            int bf = altura(n.getLeft()) - altura(n.getRight());
            System.out.print(n.getvalue() + "(bf=" + bf + "), ");
            if (Math.abs(bf) > 1) balanceado = false;
            inOrderBalance(n.getRight());
        }
    }

    public boolean estaBalanceado() {
        balanceado = true;
        checkBalance(root);
        return balanceado;
    }

    private void checkBalance(Node n) {
        if (n != null) {
            int bf = altura(n.getLeft()) - altura(n.getRight());
            if (Math.abs(bf) > 1) balanceado = false;
            checkBalance(n.getLeft());
            checkBalance(n.getRight());
        }
    }

    public void nodosDesequilibrados() {
        int[] contador = {0};
        nodosDesequilibrados(root, contador);
        System.out.println();
    }

    private void nodosDesequilibrados(Node n, int[] contador) {
        if (n != null) {
            nodosDesequilibrados(n.getLeft(), contador);
            int bf = altura(n.getLeft()) - altura(n.getRight());
            if (Math.abs(bf) > 1) {
                if (contador[0] > 0) System.out.print(" y ");
                System.out.print(n.getvalue() + "(fE = " + bf + ")");
                contador[0]++;
            }
            nodosDesequilibrados(n.getRight(), contador);
        }
    }
}