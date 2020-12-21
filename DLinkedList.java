package rtfour;

public class DLinkedList {
    private Node tail;
    private Node head;

    public DLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(String data) {
        if (isEmpty()) {
            head = new Node(data);
            tail = head;
        } else {
            Node operativeNode = new Node(data);
            operativeNode.setPrevious(head);
            head.setNext(operativeNode);
            head = operativeNode;
            head.setPrevious(head);
            if (tail.getNext() == null) {
                tail.setNext(head);
            }
        }
    }

    public void print() {
        Node operativeNode = tail;
        while (operativeNode != null) {
            System.out.println(operativeNode.getData());
            operativeNode = operativeNode.getNext();
        }
    }

}
