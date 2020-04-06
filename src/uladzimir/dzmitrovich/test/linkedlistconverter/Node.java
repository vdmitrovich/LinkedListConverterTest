package uladzimir.dzmitrovich.test.linkedlistconverter;


public class Node<T> {
    private T value;
    private Node<T> next;

    public Node() {
    }

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        //can print recursively but java.lang.StackOverflowError will be thrown for big enough lists
        Node<T> current = this;
        StringBuilder builder = new StringBuilder();
        do  {
            if (builder.length() > 0) {
                builder.append(",");
            }
            if (current.value != null) {
                builder.append(current.value);
            }
            current = current.getNext();
        }while(current != null);
        return builder.toString();
    }


}
