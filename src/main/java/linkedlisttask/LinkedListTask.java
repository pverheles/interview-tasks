package linkedlisttask;

/*
Implement method removeAll that removes all entries from a singly linked list
(every node has a pointer only to a next element).
Node with a value should be completely removed from the list.
If method finds such values and removes them - it should return true,
otherwise - false (list does not contain such values).
All entries in the list and the input argument `e` are non-null.
*/
public class LinkedListTask<E> {
    private Node<E> head;

    private static class Node<E> {
        E value;
        Node<E> next;
    }


    public boolean removeAll(E e) {
        boolean result = false;

        if (head == null) {
            return result;
        }

        while (head != null && head.value.equals(e)) {
            head = head.next;
            result = true;
        }

        if (head == null) {
            return result;
        }

        Node<E> previous = head;
        Node<E> testedNode = head.next;

        while (testedNode != null) {
            if (testedNode.value.equals(e)) {
                previous.next = testedNode.next;
                testedNode = testedNode.next;
                result = true;
            } else {
                previous = testedNode;
                testedNode = testedNode.next;
            }
        }

        return result;
    }


    /**
     *
     * This method is NOT a part of the task, it was implemented
     *
     */
    public boolean add(E e) {
        if (e == null) {
            throw new IllegalArgumentException("Null elements are not allowed");
        }
        Node<E> newNode = new Node<>();
        newNode.value = e;
        if (head == null) {
            head = newNode;
            return true;
        }

        Node<E> lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        if (head == null) {
            return builder.append(']').toString();
        }

        Node<E> node = head;
        while (true) {
            builder.append(String.valueOf(node.value));
            if (node.next == null) {
                return builder.append(']').toString();
            }
            builder.append(", ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LinkedListTask<Integer> list = new LinkedListTask<>();
        list.add(3);
        list.add(2);
        list.add(1);
//        list.add(3);
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(1);
//        list.add(4);
        System.out.println("Before" + list);

        boolean result = list.removeAll(1);
        System.out.println("Result = "+result);
        System.out.println("After" + list);
    }
}
