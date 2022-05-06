package com.subbu.framework.Base;
import java.util.*;

public class BinaryTree {
    static int sum=0;
    static int leftleaves =0;
    static int rightleaves=0;
    static Node root;
    public BinaryTree() {root=null;}
    /* Function to find sum
       of all the elements*/
    private void TopView(Node root) {
        class QueueObj {
            Node node;
            int hd;
            QueueObj(Node node,int hd) {
                this.node = node;
                this.hd = hd;
            }
        }
        Queue<QueueObj> q = new LinkedList<QueueObj>();
        Map<Integer,Node> topviewMap = new TreeMap<Integer,Node>();
        if (root ==null)
            return;
        else
            q.add(new QueueObj(root,0));
        System.out.println("The top view of the tree is :");
        while(!q.isEmpty()) {
            QueueObj tmpMap = q.poll();
        if (!topviewMap.containsKey(tmpMap.hd))
            topviewMap.put(tmpMap.hd,tmpMap.node);
        if (tmpMap.node.left !=null)
            q.add(new QueueObj(tmpMap.node.left,tmpMap.hd -1));
        if (tmpMap.node.right !=null)
            q.add(new QueueObj(tmpMap.node.right,tmpMap.hd +1));
        }
        for (Map.Entry<Integer,Node> entry : topviewMap.entrySet()) {
            System.out.println(entry.getValue().key);
        }
    }
    static int sumNodes(Node root)
    {
        if (root == null)
            return 0;
        return (root.key + sumNodes(root.left) +
                sumNodes(root.right));
    }
    static boolean isLeaf(Node node)
    {
        if (node == null)
            return false;
        if (node.left == null && node.right == null)
            return true;
        return false;
    }
    static int sumLeftLeaves(Node root) {
        // Update result if root is not NULL
        if (root != null)
        {
            // If left of root is NULL, then add key of
            // left child
            if (isLeaf(root.left))
                leftleaves += root.left.key;
            else // Else recur for left child of root
                leftleaves = sumLeftLeaves(root.left);
            // Recur for right child of root and update res
            leftleaves = sumLeftLeaves(root.right);
        }
        return leftleaves;
    }
    static int sumRightLeaves(Node root) {
        if (root != null) {
            if (isLeaf(root.right))
                rightleaves += root.right.key;
            else
                rightleaves = sumRightLeaves(root.left);
            rightleaves = sumRightLeaves(root.right);
        }
        return rightleaves;
    }
    static void sumParentNodes(Node root, int x) {
        if (root== null)
            return ;
        if ((root.left !=null && root.left.key ==x) || (root.right !=null && root.right.key ==x))
            sum += root.key;
        sumParentNodes(root.left,x);
        sumParentNodes(root.right,x);
}

    static int sumOfParentOfXUtil(Node root,
                                  int x)
    {
        sum = 0;
        sumParentNodes(root, x);

        // required sum of parent nodes
        return sum;
    }
    static int sumNodesByLevel(int l)
    {
        // no of leaf nodes
        int leafNodeCount = (int)Math.pow(2, l - 1);

        // list of vector to store
        // nodes of all of the levels
        Vector<Vector
                <Integer>> vec = new Vector<Vector<Integer>>();
        //initialize
        for (int i = 1; i <= l; i++)
            vec.add(new Vector<Integer>());

        // store the nodes of last level
        // i.e., the leaf nodes
        for (int i = 1;i <= leafNodeCount; i++)
            vec.get(l - 1).add(i);
        // store nodes of rest of
        // the level by moving in
        // bottom-up manner
        for (int i = l - 2; i >= 0; i--)
        {
            int k = 0;

            // loop to calculate values
            // of parent nodes from the
            // children nodes of lower level
            while (k < vec.get(i + 1).size() - 1)
            {

                // store the value of parent
                // node as sum of children nodes
                vec.get(i).add(vec.get(i + 1).get(k) +
                        vec.get(i + 1).get(k + 1));
                k += 2;
            }
        }
        int sum = 0;

        // traverse the list of vector
        // and calculate the sum
        for (int i = 0; i < l; i++)
        {
            for (int j = 0;
                 j < vec.get(i).size(); j++)
                sum += vec.get(i).get(j);
        }
        return sum;
    }
    static void  insertLevelOrder (Node root,int key) {
        if (root==null){
            root = new Node(key);
            return;
        }
        if (root.left ==null) {
            root.left = new Node(key);
            return;
        }
        if (root.right==null) {
            root.right = new Node(key);
            //System.out.println("Right Leaves:" +root.right.key);
            return;
        }
        insertLevelOrder(root.left,key);
        insertLevelOrder(root.right,key);
    }
    static Node deleteNode(Node root,int key) {
        if (root==null)
            return root;
        if (key < root.key) {
            root.left = deleteNode(root.left,key);
        }
        else if (key > root.key) {
            root.right =deleteNode(root.right,key);
        }
        else if (root.key==key) {
            //Root with only left child
            if (root.right==null && root.left !=null) {
                root.key = root.left.key;
                root.left = deleteNode(root.left,key);
            }
            //Root with only right child
            else if (root.left==null && root.right!=null) {
                root.key = root.right.key;
                root.right = deleteNode(root.right,key);
            }
            //Root with no children
            else if (root.left==null && root.right==null) {
                root=null;
            }
            //Root with left and right child
            else if (root.left!=null && root.right!=null) {
                root.key =root.left.key;
                root.left = deleteNode(root.left,root.key);
            }
        }
        return root;
    }
    static int height(Node root) {
        if (root==null)
            return 0;
        else {
            int lheight =height(root.left);
            int rheight= height(root.right);
            if (lheight > rheight)
                return lheight +1;
            else
                return rheight +1;
        }
    }
    static void printCurrentLevel(Node root, int level) {
        if (root==null)
            return;
        if (level ==1)
            System.out.println(root.key + " ");
        if (level > 1) {
            printCurrentLevel(root.left,level-1);
            printCurrentLevel(root.right,level-1);
        }
    }
    static void printLevelOrder() {
        int h =height(root);
        for (int i=1;i < h;i++)
            printCurrentLevel(root,i);
    }
    static boolean isvalidBST(Node root) {
        if (root==null) return true;
        else
            if (root.left !=null && root.left.key > root.key)
                    return false;
        else
            if (root.right !=null && root.right.key < root.key)
                return false;
        else
            if (!isvalidBST(root.left) || !isvalidBST(root.right))
            return false;
        else
            return true;
    }
    // Driver Code
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(2);
        tree.root.right.right = new Node(7);
        //tree.root.right.left.right = new Node(8);
        System.out.println("Is this a Valid BST:" +isvalidBST(tree.root));
        //insertLevelOrder(root,12);
        tree.deleteNode(tree.root,4);
        int sum = sumNodes(tree.root);
        int sumParent = sumOfParentOfXUtil(tree.root,5);
        int sumLeftLeaves = sumLeftLeaves(tree.root);
        int sumRightLeaves = sumRightLeaves(tree.root);
        System.out.println("Sum of all the elements is: " + sum);
        System.out.println("Sum of all the Parent nodes is: " + sumParent);
        System.out.println("Sum of all the Left Leaf nodes is: " + sumLeftLeaves);
        System.out.println("Sum of all the Right Leaf nodes is: " + sumRightLeaves);
        //System.out.println("Sum of all the Nodes By Level is: " + sumNodesByLevel(2));
        System.out.println("Level Order Traversal of Binary Tree:");
        tree.printLevelOrder();
        tree.TopView(tree.root);
    }
}
class Node {
        int key;
        Node left, right;
        public Node(int key) {
            this.key=key;
            left=right=null;
        }
}