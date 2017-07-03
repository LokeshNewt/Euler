package practice;

/**
 * Created by neerbans on 6/15/2017.
 */
public class LinkList {

    public static void main (String [] args) {

        LinkList obj = new LinkList();
        Node head = obj.createLinkList(5);
        obj.printLinkList(head);
        head = obj.reverseLinkList(head);
        System.out.println();
        obj.printLinkList(head);
    }

    private Node reverseLinkList(Node node) {
        if (node == null) {
            return null;
        }
        Node prev = null;
        while (node != null) {
            Node n = node.next;
            node.next = prev;
            prev = node;
            node = n;
        }
        return prev;
    }

    private void printLinkList(Node node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.print("null");
    }

    private Node createLinkList(int size) {
        Node head = new Node();
        head.val = 0;
        Node prev = head;
        for (int i=1; i<size; i++) {
            Node n = new Node();
            n.val = i;
            prev.next = n;
            prev = n;
        }
        return head;
    }
}

class Node {
    int val;
    Node next;
}
