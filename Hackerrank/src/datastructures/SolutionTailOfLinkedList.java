package datastructures;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SolutionTailOfLinkedList {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;

        public SinglyLinkedList() {
            this.head = null;
        }

      
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));
            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the insertNodeAtTail function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
	static SinglyLinkedListNode insertNodeAtTail1(SinglyLinkedListNode head, int data) {
		if (head == null) {
			head = new SinglyLinkedListNode(data);
			return head;
		}
		SinglyLinkedListNode end = head;
		while (end.next != null) {
			end = end.next;
		}
		end.next = new SinglyLinkedListNode(data);
		return head;
	}
	
	static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
		if (head == null) {
			head = new SinglyLinkedListNode(data);
			return head;
		}
		//SinglyLinkedListNode end = head;
		while (head.next != null) {
			System.out.println("--- " + head.data);
			head = head.next;
		}
		head.next = new SinglyLinkedListNode(data);
		return head;
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        	
          SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, llistItem);

          llist.head = llist_head;
        }



        printSinglyLinkedList(llist.head, "\n", bufferedWriter);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
