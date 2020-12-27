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

    public void addLast(Object data) {
        Node operativeNode = new Node(data);
        if (isEmpty()) {
            head = operativeNode;
            tail = head;
        } else {
            operativeNode.setPrevious(head);
            head.setNext(operativeNode);
            head = operativeNode;
            if (tail.getNext() == null) {
                tail.setNext(operativeNode);
            }
        }
    }

    public void printTailAndHead() {
        System.out.println("Tail:" + tail.getData().toString() + " Head:" + head.getData().toString() + "\n");
    }

    public void addInOrder(Object data) {
        Node operativeNode = tail;
        Node newNode = new Node(data);
        if (isEmpty()) {
            addLast(data);
        } else {
            while (operativeNode != null) {
                if (newNode.getData().toString().compareTo(operativeNode.getData().toString()) < 0) {
                    addBeforeExistingNode(operativeNode, newNode);
                    break;
                }
                if (operativeNode.getNext() != null) {
                    if (newNode.getData().toString().compareTo(operativeNode.getNext().getData().toString()) < 0) {
                        addAfterExistingNode(operativeNode, newNode);
                        break;
                    }
                } else if (operativeNode.getNext() == null) {
                    addLast(data);
                    break;
                }
                operativeNode = operativeNode.getNext();
            }
        }

    }

    public void addBeforeExistingNode(Node existingNode, Node newNode) {
        newNode.setNext(existingNode);
        if (existingNode.getPrevious() != null) {
            existingNode.getPrevious().setNext(newNode);
            newNode.setPrevious(existingNode.getPrevious());
        } else {
            tail = newNode;
        }
        existingNode.setPrevious(newNode);

    }

    public void addAfterExistingNode(Node existingNode, Node newNode) {
        newNode.setPrevious(existingNode);
        if (existingNode.getNext() != null) {
            existingNode.getNext().setPrevious(newNode);
            newNode.setNext(existingNode.getNext());
        } else {
            head = newNode;
        }
        existingNode.setNext(newNode);
    }

    public Node getTail() {
        return tail;
    }

    public Node getHead() {
        return head;
    }

    public Node findNode(Object data) {
        Node operativeNode = tail;
        while (operativeNode != null) {
            if (operativeNode.getData() == data) {
                return operativeNode;
            }
            operativeNode = operativeNode.getNext();
        }
        return null;

    }

    public void print() {
        Node operativeNode = tail;
        while (operativeNode != null) {
            System.out.println(operativeNode.getData());
            operativeNode = operativeNode.getNext();
        }
        System.out.println();
        printTailAndHead();
    }

}
