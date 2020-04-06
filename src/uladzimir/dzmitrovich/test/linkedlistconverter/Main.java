package uladzimir.dzmitrovich.test.linkedlistconverter;

import sun.plugin.dom.exception.InvalidStateException;

public class Main {

    public static void main(String[] args) {
        // empty list:
        Node<Integer> head = new Node<>();

        Node<Integer>[] results = convertLinkedLists(head);
        for (Node<Integer> result : results) {
            System.out.println(result.toString());
        }

        // list with odd number of elements
        head = new Node<>();
        Node<Integer> current = head;
        for (int index = 0; index <= 39; index++) {
            current.setNext(new Node<>(index));
            current = current.getNext();
        }

        results = convertLinkedLists(head);
        for (Node<Integer> result : results) {
            System.out.println(result.toString());
        }


        // list with even number of elements
        head = new Node<>();
        current = head;
        for (int index = 0; index <= 100000; index++) {
            current.setNext(new Node<>(index));
            current = current.getNext();
        }

        results = convertLinkedLists(head);
        for (Node<Integer> result : results) {
            System.out.println(result.toString());
        }
    }

    /**
     * Function that will get a pointer to a one-way-linked list head and return an array of two linked lists.
     * First, of them, they will contain only odd elements from the input, while second only even elements.
     * Both returned lists  will be in a reversed order.
     * @param head a pointer to a one-way-linked list head
     * @param <T> type of elements in linked lists
     * @return  an array of two linked lists First, of them, they will contain only odd elements from the input, while second only even elements
     */
    public static <T> Node<T>[] convertLinkedLists(Node<T> head) {
        if (head == null) throw new InvalidStateException("Input array can't be null");

        Node<T> current = head.getNext();
        Node<T> oddCurrent = null;
        Node<T> evenCurrent = null;
        Node<T> next = null;
        int index = 1;
        while (current != null) {

            next = current.getNext();
            if (index % 2 == 0) {
                evenCurrent = moveItem(current, evenCurrent);
            } else {
                oddCurrent = moveItem(current, oddCurrent);
            }

            current = next;
            index++;
        }

        Node<T> oddHead = new Node<>();
        oddHead.setNext(oddCurrent);
        Node<T> evenHead = new Node<>();
        evenHead.setNext(evenCurrent);

        return new Node[]{oddHead, evenHead};
    }

    private static <T> Node<T> moveItem(Node<T> current, Node<T> evenCurrent) {
        if (evenCurrent == null) {
            current.setNext(null);//end of new array
            return current;
        } else {
            current.setNext(evenCurrent);
            return current;
        }
    }
}
