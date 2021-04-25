package basicds.linkedlist;


public class LinkedListNode {
    public int val;
    public LinkedListNode next;

    public LinkedListNode() {
    }

    public LinkedListNode(int val) {
        this.val = val;
    }

    public LinkedListNode(int val, LinkedListNode next) {
        this.val = val;
        this.next = next;
    }

}
