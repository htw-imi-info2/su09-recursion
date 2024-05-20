package towers;

public class Tower<E extends Comparable<E>> {
    Node<E> top;
    String marker = "";
    public void setMarker(String marker) {this.marker = marker;}
    public E pop() throws EmptyTowerException {
        if (top == null) {
            throw new EmptyTowerException("Tower is empty!");
        }
        E result = top.element;
        top = top.next;
        return result;
    }

    public Tower<E> push(E element) throws TowerOrderException {
        Node<E> newNode = new Node<>(element, null);
        if (top != null) {
            if (element.compareTo(top.element) > 0){
                throw new TowerOrderException(""+element +" cannot be put on top of "+top.element);
            }
            newNode.next = top;
        }
        top = newNode;
        return this;
    }

    @Override
    public String toString() {
        if (top == null) {
            return marker;
        }
        return marker+top.toString();
    }

    public int size() {
        if (top == null)
            return 0;
        return top.size();
    }

    class Node<E> {
        private E element;
        private Node<E> next;

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


}
