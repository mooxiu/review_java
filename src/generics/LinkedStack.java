package generics;

public class LinkedStack<U> {
    private static class Node<T> {
        T value; // value of the node
        Node<T> next;  // pointer to the next one

        Node() {
           value = null;
           next = null;
        }

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        boolean end() {
            return this.value == null && this.next == null;
        }
    }

    private Node<U> top = new Node<U>();
    public void push(U item) {
        top = new Node<U>(item, top);
    }
    public U pop() {
        var res = top.value;
        if (!top.end()) {
            top = top.next;
        }
        return res;
    }

    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack<>();
        for (String s : "Phasers on strun!".split(" ")) {
            lss.push(s);
        }
        String s;
        while ((s = lss.pop()) != null) {
            System.out.println(s);
        }
    }
}
