package towers;

class Node<E> {
     E element;
     Node<E> next;

    Node(E element, Node<E> next) {
        this.element = element;
        this.next = next;
    }

    @Override
    public String toString() {
        return "add recursive toString implementation here!";
    }

    public int size() {
        return 0;
        // add recursive size implementation here!
    }
}
