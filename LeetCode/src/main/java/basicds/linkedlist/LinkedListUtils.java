package basicds.linkedlist;


public class LinkedListUtils {


    public static LinkedListNode create(LinkedListNode head, int[] array) {
        if (array.length == 0) {
            return null;
        } else if (array.length == 1) {
            return head = new LinkedListNode(array[0]);
        } else {
            head = new LinkedListNode(array[0]);
            LinkedListNode index = head;
            for (int i = 1; i < array.length - 1; i++) {
                index.next = new LinkedListNode();
                index = index.next;
                index.val = array[i];
            }
            index.next = new LinkedListNode(array[array.length - 1]);
            return head;
        }
    }


    public static void printLinkedList(LinkedListNode head) {
        LinkedListNode temp = head;
        if (temp == null) {
            System.out.print("null");
        } else if (temp.next == null) {
            System.out.println(temp.val);
        } else {
            while (temp.next != null) {
                System.out.print(temp.val + "--->");
                temp = temp.next;
            }
            System.out.println(temp.val);
        }
    }

    public static int len(LinkedListNode head) {
        LinkedListNode temp = head;
        if (temp == null) {
            return 0;
        } else {
            int length = 1;
            while (temp.next != null) {
                temp = temp.next;
                length++;
            }
            return length;
        }
    }

    public static void main(String[] args) {
        int[] a = {93,94,95};
        LinkedListNode head = create(new LinkedListNode(), a);
        printLinkedList(head);
        System.out.println("\n" + len(head));
    }
}
