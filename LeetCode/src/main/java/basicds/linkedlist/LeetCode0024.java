package basicds.linkedlist;

import basicds.linkedlist.LinkedListNode;
import basicds.linkedlist.LinkedListUtils;


/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
 */
public class LeetCode0024 {
    /**
     * 像是用递归的方法。
     *
     * @param head
     * @return
     */
    public static LinkedListNode swapPairs(LinkedListNode head) {
        // terminator
        System.out.println("处理：");
        LinkedListUtils.printLinkedList(head);
        LinkedListNode currentNode = head;
        LinkedListNode tempNode = currentNode.next;
        if (currentNode == null) {
            // process result 
            return currentNode;
        }
        // process current logic 
        currentNode.next = tempNode.next;
        tempNode.next = currentNode;
        System.out.println("处理后：");
        LinkedListUtils.printLinkedList(tempNode);

        // drill down 
        swapPairs(head.next);
        // restore current status 
        System.out.println("最终结果：");
        LinkedListUtils.printLinkedList(head);
        return head;
    }

    /**
     * 修改后
     * @param head
     * @return
     */
    public static LinkedListNode swapPairs_2(LinkedListNode head) {
        // terminator
        System.out.println("处理：");
        LinkedListUtils.printLinkedList(head);

        if (head == null || head.next == null) {
            // process result 
            return head;
        }
        // process current logic 
        LinkedListNode currentNode = head;
        LinkedListNode tempNode = currentNode.next;
        // drill down 
        currentNode.next = swapPairs_2(tempNode.next);
        tempNode.next = currentNode;
        System.out.println("处理后：");
        LinkedListUtils.printLinkedList(tempNode);

        // restore current status 
        System.out.println("最终结果：");
        LinkedListUtils.printLinkedList(tempNode);
        return tempNode;
    }

    /**
     * 这个题目要求我们从第一个节点开始两两交换链表中的节点，且要真正的交换节点。
     *
     * 算法：
     *
     * 从链表的头节点 head 开始递归。
     * 每次递归都负责交换一对节点。由 firstNode 和 secondNode 表示要交换的两个节点。
     * 下一次递归则是传递的是下一对需要交换的节点。若链表中还有节点，则继续递归。
     * 交换了两个节点以后，返回 secondNode，因为它是交换后的新头。
     * 在所有节点交换完成以后，我们返回交换后的头，实际上是原始链表的第二个节点。
     *
     * @param head
     * @return
     */
    public static LinkedListNode swapPairs_STDRecursion(LinkedListNode head) {


        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Nodes to be swapped
        LinkedListNode firstNode = head;
        LinkedListNode secondNode = head.next;

        // Swapping
        firstNode.next  = swapPairs_STDRecursion(secondNode.next);
        secondNode.next = firstNode;

        // Now the head is the second node
        return secondNode;

    }

    /**
     * 我们把链表分为两部分，即奇数节点为一部分，偶数节点为一部分，A 指的是交换节点中的前面的节点，B 指的是要交换节点中的后面的节点。在完成它们的交换，我们还得用 prevNode 记录 A 的前驱节点。
     *
     * 算法：
     * 1.firstNode（即 A） 和 secondNode（即 B） 分别遍历偶数节点和奇数节点，即两步看作一步。
     * 2.交换两个节点：
     *  firstNode.next = secondNode.next
     *  secondNode.next = firstNode
     * 3.还需要更新 prevNode.next 指向交换后的头。
     *  prevNode.next = secondNode
     * 4.迭代完成后得到最终的交换结果。
     *
     *
     * 迭代是从上到下，一直到底，
     * 递归是触底反弹
     * @param head
     * @return
     */
    public static LinkedListNode swapPairs_STDIteration(LinkedListNode head){
        // Dummy node acts as the prevNode for the head node
        // of the list and hence stores pointer to the head node.
        LinkedListNode dummy = new LinkedListNode(-1);
        dummy.next = head;

        LinkedListNode prevNode = dummy;

        while ((head != null) && (head.next != null)) {
            // Nodes to be swapped
            LinkedListNode firstNode = head;
            LinkedListNode secondNode = head.next;

            // Swapping
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Reinitializing the  head and prevNode (after swapping) for next swap
            prevNode = firstNode;
            // jump
            head = firstNode.next;
        }

        // Return the new head node.
        return dummy.next;

    }

    public static void main(String[] args) {
        int[] a = {91,92,93,94,95,96,97};

        LinkedListNode l1 = new LinkedListNode();
        l1 = LinkedListUtils.create(l1, a);
        LinkedListUtils.printLinkedList(l1);
        LinkedListUtils.printLinkedList(swapPairs_STDIteration(l1));

    }
}
