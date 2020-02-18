package ru.job4j.list;

class Node<T> {
    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    boolean hasCycle(Node first) {
        boolean result = false;
        Node<T> turtle = next;
        Node<T> hare = next;

        while (hare != null && hare.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;
            if (turtle == hare) {
                result = true;
                break;
            }
        }
        return result;
    }
}
