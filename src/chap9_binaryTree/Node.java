package chap9_binaryTree;

public class Node<T> {
    public T data;
    public Node<T> left = null;
    public Node<T> right = null;

    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }

    public Node(Node<T> left, Node<T> right) {
        this.left = left;
        this.right = right;
    }

    public Node(T data, Node<T> left, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
