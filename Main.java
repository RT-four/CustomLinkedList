package rtfour;

public class Main {
    public static void main(String[] args) {
        DLinkedList list = new DLinkedList();
        String stringData = "Darwin Brisbane Perth Melbourne Adelaide Sydney Canberra";
        String[] data = stringData.split(" ");
        for (String s : data) {
            list.addLast(s);
        }
        list.print();
        list.addBeforeExistingNode(list.getHead().getPrevious(), new Node("Africa"));
        list.print();
        list.addBeforeExistingNode(list.getTail(), new Node("Russia"));
        list.print();
//        list.addInOrder("Africa");
//        list.print();
//        stringData = " Adelaide Sydney Canberra Darwin Brisbane Perth Melbourne";
//        data = stringData.split(" ");
//        for (String s : data) {
//            list.addInOrder(s);
//        }
//        list.print();
//
//        DLinkedList numList = new DLinkedList();
//        stringData = "3 5 3 5 22 2 3";
//        data = stringData.split(" ");
//        for (String s : data) {
//            numList.addLast(s);
//        }
//        numList.print();
    }
}
