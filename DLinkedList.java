package rtfour;

import java.util.function.DoublePredicate;

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
        if (isEmpty()) {
            head = new Node(data);
            tail = head;
        } else {
            Node operativeNode = new Node(data);
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
        System.out.println(operativeNode.getData().toString().compareTo(data.toString()));
        while (operativeNode != null) {
            System.out.println(operativeNode.getData().toString().compareTo(data.toString()));
            if (operativeNode.getData().toString().compareTo(data.toString()) == 0) {
                break;
            } else if (operativeNode.getData().toString().compareTo(data.toString()) > 0) {
                addBeforeExistingNode(operativeNode, newNode);
                break;
            } else if (operativeNode.getNext() == null) {
                addLast(newNode);
                break;
            }
            operativeNode = operativeNode.getNext();
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
            newNode.setNext(existingNode.getNext());
            existingNode.getNext().setPrevious(newNode);
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
