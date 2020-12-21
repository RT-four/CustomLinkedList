package rtfour;

public class Main {
    public static void main(String[] args) {
        DLinkedList list = new DLinkedList();
        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";
        String[] data = stringData.split(" ");
        for (String s : data) {
            list.add(s);
        }
        list.print();
    }
}
