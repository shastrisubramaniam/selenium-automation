package com.subbu.framework.Base;

import java.util.Stack;

public class SingleLinkedList {
    SingleLinkedListNode head;
    static class SingleLinkedListNode {
        int data;
        SingleLinkedListNode next;
        public SingleLinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static SingleLinkedList reverse(SingleLinkedList llist) {
        Stack<Integer> stack = new Stack<>();
        SingleLinkedListNode head = llist.head;
        SingleLinkedListNode tail;
        while (head !=null) {
            stack.push(head.data);
            head= head.next;
        }
        tail = llist.head;
        while (tail !=null) {
            tail.data=stack.pop();
            tail=tail.next;
        }
        return llist;
    }
    public static SingleLinkedList insert(SingleLinkedList llist,int data) {
        SingleLinkedListNode newnode = new SingleLinkedListNode(data);
        newnode.next = null;
        SingleLinkedListNode last = llist.head;
        if (llist.head ==null) {
            llist.head = newnode;
        }
        else {
            while(last.next !=null) {
                last = last.next;
            }
            last.next = newnode;
        }
        return llist;
    }
    public static void printList(SingleLinkedList llist) {
        SingleLinkedListNode head = llist.head;
        System.out.println("LinkedList:");
        while(head!=null) {
            System.out.println(head.data + " ");
            head = head.next;
        }
    }
    public static void main(String[] args) {
        SingleLinkedList llist = new SingleLinkedList();
        insert(llist,1);
        insert(llist,2);
        insert(llist,3);
        insert(llist,4);
        insert(llist,5);
        printList(llist);
        reverse(llist);
        printList(llist);
    }
}
