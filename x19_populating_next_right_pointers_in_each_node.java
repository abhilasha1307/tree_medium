package TREE.TREE_medium;

/*
=========================================================
PROBLEM:) 116
=========================================================
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

The number of nodes in the given tree is less than 4096.
-1000 <= node.val <= 1000
*/

/*




Time : O(N)
Space : O(1) if we dont consider the recursion stack, else O(log n) as its given that the tree is a perfect BT
*/

/*
ITERATIVE SOLUTION

*/
public class x19_populating_next_right_pointers_in_each_node {
  static class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }

  Node root;

  public static Node connect(Node root) {
    if (root == null) {
      return root;
    }

    Util(root.left, root.right);
    return root;
  }

  public static void Util(Node node1, Node node2) {
    if (node1 == null)
      return;
    node1.next = node2;
    Util(node1.left, node1.right);
    Util(node2.left, node2.right);
    Util(node1.right, node2.left);
  }

  // code to print level order

  public static void LevelOrder(Node node) {
    if (node == null) {
      System.out.println("#");
    }

    if (node.left == null && node.right == null) {
      System.out.println("[" + node.val + "#" + "]");
    }

    int h = height(node);
    System.out.print("[");
    for (int i = 1; i <= h; i++) {
      Node t = node;
      while (t != null) {
        System.out.print(t.val + ",");
        t = t.next;
      }
      System.out.print("#" + ",");
      node = node.left;
    }
    System.out.println("]");
  }

  public static int height(Node node) {
    if (node == null) {
      return 0;
    }

    else {
      int left_height = height(node.left);
      int right_height = height(node.right);

      if (left_height > right_height) {
        return (left_height + 1);
      } else {
        return (right_height + 1);
      }
    }
  }

  public static void main(String[] args) {
    x19_populating_next_right_pointers_in_each_node obj = new x19_populating_next_right_pointers_in_each_node();
    obj.root = new Node(1);
    obj.root.left = new Node(2);
    obj.root.right = new Node(3);
    obj.root.left.left = new Node(4);
    obj.root.left.right = new Node(5);
    obj.root.right.left = new Node(6);
    obj.root.right.right = new Node(7);

    LevelOrder(connect(obj.root));

  }

}
