package towers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {


    @Test
    void testToString() {
        Node<String> list = new Node<>("A", new Node<>("B",null));
        assertEquals("A->B", list.toString());
    }

    @Test
    void size() {

        Node<String> list = new Node<>("A", new Node<>("B",null));
        assertEquals(2, list.size());

    }
}