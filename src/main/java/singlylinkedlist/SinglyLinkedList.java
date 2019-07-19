package singlylinkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Create singly linked list with two methods push and reverse.
 */
public class SinglyLinkedList<T> implements Iterable<T> {

    private Node<T> head;

    public void push(T value) {
        if (head == null) {
            head = new Node<>();
            head.value = value;
        } else {
            Node<T> node = new Node<>();
            node.value = value;
            node.link = head;
            head = node;
        }
    }

    public SinglyLinkedList<T> reverse() {
        //        NULL <- A <- B <- C (head)
        //        A <- B -> C
        // (head) A -> B -> C -> NULL

        if (head == null) {
            return this;
        }

        if (head.link == null) {
            return this;
        }

        Node<T> element = head; // C
        Node<T> nextElement = element.link; // B
        Node<T> nextNextElement = nextElement.link;

        element.link = null;

        while (nextNextElement != null) {
            Node<T> temp = nextNextElement.link;

            nextElement.link = element;
            nextNextElement.link = nextElement;

            element = nextElement;
            nextElement = nextNextElement;
            nextNextElement = temp;
        }

        nextElement.link = element;
        head = nextElement;

        return this;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (current == null) {
                    throw new NoSuchElementException();
                }

                Node<T> result = current;
                current = current.link;

                return result.value;
            }
        };
    }

    private class Node<T> {
        private T value;
        private Node<T> link;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        Iterator<T> iterator = iterator();

        while (iterator.hasNext()) {
            result.append(iterator.next());
            if (iterator.hasNext()) {
                result.append(", ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        SinglyLinkedList<String> list = createTestLinkedList();
        System.out.println("Original: " + list + "; Reversed: " + list.reverse());

        list = createTestLinkedList("A");
        System.out.println("Original: " + list + "; Reversed: " + list.reverse());

        list = createTestLinkedList("A", "B");
        System.out.println("Original: " + list + "; Reversed: " + list.reverse());

        list = createTestLinkedList("A", "B", "C");
        System.out.println("Original: " + list + "; Reversed: " + list.reverse());
        list.reverse();

        list = createTestLinkedList("A", "B", "C", "D");
        System.out.println("Original: " + list + "; Reversed: " + list.reverse());
    }

    private static SinglyLinkedList<String> createTestLinkedList(String... elements) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        for (String element : elements) {
            list.push(element);
        }
        return list;
    }
}
