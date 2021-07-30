import java.util.*;

public class p3_Connect_nodes_at_same_level {

  static class Node {
    int data;
    Node left;
    Node right;
    Node next;

    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
      this.next = null;
    }
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.right = new Node(7);

    Connect(root);
    printInorder(root);
    System.out.println();
    printList(root);
  }

  public static void Connect(Node root) {
    Queue<Node> Q = new LinkedList<>();

    Q.add(root);
    Q.add(null);

    while (!Q.isEmpty()) {
      Node temp = Q.poll();
      if (temp != null) {
        temp.next = Q.peek();
        if (temp.left != null)
          Q.add(temp.left);
        if (temp.right != null)
          Q.add(temp.right);
      }

      else if (!Q.isEmpty())
        Q.add(null);
    }
  }

  public static void printList(Node root) {
    if (root == null) {
      return;
    }

    Node next_node = null;
    while (root != null) {
      System.out.print(root.data + " ");

      if (root.left != null && next_node == null) {
        next_node = root.left;
      } else if (root.right != null && next_node == null) {
        next_node = root.right;
      }
      root = root.next;
    }

    printList(next_node);
  }

  public static void printInorder(Node root) {
    if (root != null) {
      printInorder(root.left);
      System.out.print(root.data + " ");
      printInorder(root.right);
    }
  }
}
