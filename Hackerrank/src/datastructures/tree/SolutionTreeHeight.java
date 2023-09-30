package datastructures.tree;

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class SolutionTreeHeight {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static int height(Node root) {
		if (root == null)
			return 0;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		Node front = null;
		int h = -1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				front = queue.poll();
				if (front.right != null) {
					queue.add(front.right);
				}
				if (front.left != null) {
					queue.add(front.left);
				}
			}
			h++;
		}
		return h;
	}
	
	public static int height1(Node root) {
		if (root == null)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}


	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }	
}