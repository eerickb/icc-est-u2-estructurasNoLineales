package materia.controllers;

import materia.models.Node;

public class BinaryTree {

    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node padre, int value) {
        if (padre == null) {
            return new Node(value);
        }
        if(value <= padre.getvalue()){
            padre.setLeft(insertRec(padre.getLeft(), value));
        } else if (value > padre.getvalue()){
            padre.setRight(insertRec(padre.getRight(), value));
        }
        return padre;
    }

    public void printPreorder() {
        printPreorder(root);
    }
    
    private void printPreorder(Node node){
        if (node != null) {
            System.out.print(node.getvalue() + ", ");
            printPreorder(node.getLeft());
            printPreorder(node.getRight());
        }
    }

    public void printPosOrder() {
        printPosOrder(root);
    }

    private void printPosOrder(Node node){
        if (node != null) {
            printPosOrder(node.getLeft());
            printPosOrder(node.getRight());
            System.out.print(node.getvalue() + ", ");
        }
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node node){
        if (node != null) {
            printInOrder(node.getLeft());
            System.out.print(node.getvalue() + ", ");
            printInOrder(node.getRight());
        }
    }

    public boolean findeValue(int value) {
        return findeValueRec(root, value);
    }

    private boolean findeValueRec(Node node, int value) {
        if (node == null) {
            return false;
    }
    if (node.getvalue() == value) {
        return true;
    } else if (value < node.getvalue()) {
        return findeValueRec(node.getLeft(), value);
    } else {
        return findeValueRec(node.getRight(), value);
        }
    }
}