package materia.controllers;

import materia.models.Node;

public class AVLTree {

    private Node root;

    public AVLTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node node, int value) {
        if (node == null) {
            Node newNode = new Node(value);
            newNode.setHeight(1);
            System.out.println("Nodo insertado -> " + value + " con balance 0");
            return newNode;
        }

        if (value <= node.getvalue()) {
            node.setLeft(insertRec(node.getLeft(), value));
        } else if (value > node.getvalue()) {
            node.setRight(insertRec(node.getRight(), value));
        } else {
            return node;
        }

        int altura = 1 + Math.max(height(node.getLeft()), height(node.getRight()));
        node.setHeight(altura);

        int balance = getBalance(node);

        System.out.println("Nodo actual -> " + node.getvalue());
        System.out.println("\tAltura -> " + altura);
        System.out.println("\tBalance -> " + balance);

        // CASO IZQUIERDA - IZQUIERDA
        if (balance > 1 && value < node.getLeft().getvalue()) {
            System.out.println("Rotacion Simple Derecha");
        }

        // CASO DERECHA - DERECHA
        if (balance < -1 && value > node.getRight().getvalue()) {
            System.out.println("Rotacion Simple Izquierda");
        }

        // CASO IZQUIERDA - DERECHA
        if (balance > 1 && value > node.getLeft().getvalue()) {
            System.out.println("Cambio ");
            node.setLeft(leftRotation(node.getLeft()));
            System.out.println("Rotacion Simple Derecha");
            return rightRotation(node);
        }

        // CASO DERECHA - IZQUIERDA
        if (balance < -1 && value < node.getRight().getvalue()) {
            System.out.println("Cambio ");
            node.setRight(rightRotation(node.getRight()));
            System.out.println("Rotacion Simple Izquierda");
            return leftRotation(node);
        }

        return node;
    }

    public int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }

    public int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    private Node leftRotation(Node x){
        Node y = x.getRight();
        Node temp = y.getLeft();
        System.out.println("Rotacion Izquierda en nodo: " + x.getvalue() + ", con balance = " + getBalance(x));
        // Realizar la rotación
        y.setLeft(x);
        x.setRight(temp);

        // Actualizar las alturas de X y Y
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);

        // Imprimir informacion despues de la rotacion
        System.out.println("Nueva raiz despues de la rotacion " + y.getValue());

        // Devolver la nueva raiz
        return y;
    }

    private Node rightRotation(Node y){
        Node x = y.getLeft();
        Node temp = x.getRight();
        System.out.println("Rotacion Derecha en nodo: " + y.getvalue() + ", con balance = " + getBalance(y));
        // Realizar la rotación
        x.setRight(y);
        y.setLeft(temp);

        // Actualizar las alturas de X y Y
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);

        //Imprimir informacion despues de la rotacion
        System.out.println("Nueva raiz despues de la rotacion " + x.getValue());

        // Devolver la nueva raiz
        return x;
    }
}