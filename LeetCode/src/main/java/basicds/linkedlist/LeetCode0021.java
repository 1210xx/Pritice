package basicds.linkedlist;

import basicds.linkedlist.LinkedListNode;


/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class LeetCode0021 {

    /**
     * 递归
     * @param l1
     * @param l2
     * @return
     */
    public static LinkedListNode mergeTwoLists(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    /**
     * 我们可以用迭代的方法来实现上述算法。当 l1 和 l2 都不是空链表时，
     * 判断 l1 和 l2 哪一个链表的头节点的值更小，将较小值的节点添加到结果里，
     * 当一个节点被添加到结果里之后，将对应链表中的节点向后移一位。
     * 迭代
     * @param l1
     * @param l2
     * @return
     */
    public static LinkedListNode mergeTwoLists_iteration(LinkedListNode l1, LinkedListNode l2){
        LinkedListNode prehead = new LinkedListNode(-1);

        LinkedListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
    public static void main(String[] args) {
        LinkedListNode l1 = new LinkedListNode(1) ;
        LinkedListNode l2 = new LinkedListNode(2);
        int[] a = {2,4,5};
        int[] b = {4,5,6};
        LinkedListNode l1_index = l1;
        for (int i : a){
            System.out.println("a[i] = :" + i);
            l1_index.next = new LinkedListNode(i);
            l1_index = l1_index.next;
        }
        LinkedListNode l2_index = l2;
        for (int i : b){
            System.out.println("b[i] = :" + i);
            l2_index.next = new LinkedListNode(i);
            l2_index = l2_index.next;
        }
//
//        while (l1 != null){
//            System.out.print(" " +l1.val);
//            l1 = l1.next;
//        }
//        System.out.println();
//        while (l2 != null){
//            System.out.print(" " +l2.val);
//            l2 = l2.next;
//        }

        LinkedListNode linkedListNode = mergeTwoLists_iteration(l1, l2);
        while (linkedListNode != null){
            System.out.print(" " + linkedListNode.val);
            linkedListNode = linkedListNode.next;
        }
    }
}

