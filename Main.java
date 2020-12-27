package rtfour;

public class Main {
    public static void main(String[] args) {
        DLinkedList list = new DLinkedList();

        String stringData = "Alfred Bob Alex Rich";
        String[] data = stringData.split(" ");
        for (String s : data) {
            list.addInOrder(s);
        }

        list.print();
    }
}
