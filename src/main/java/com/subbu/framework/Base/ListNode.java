package com.subbu.framework.Base;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    public static void main(String[] args) {
    }
}
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}