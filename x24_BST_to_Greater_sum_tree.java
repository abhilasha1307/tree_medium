import java.util.ArrayDeque;
import java.util.Deque;

/*
PROBLEM:)
Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

As a reminder, a binary search tree is a tree that satisfies these constraints:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

The number of nodes in the tree is in the range [1, 100].
0 <= Node.val <= 100
All the values in the tree are unique.
root is guaranteed to be a valid binary search tree.
*/
public class x24_BST_to_Greater_sum_tree {

 static class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
   this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
   this.val = val;
   this.left = left;
   this.right = right;
  }
 }

 public static void main(String[] args) {
  TreeNode root = new TreeNode(4);
  root.left = new TreeNode(1);
  root.left.left = new TreeNode(0);
  root.left.right = new TreeNode(2);
  root.left.right.right = new TreeNode(3);

  root.right = new TreeNode(6);
  root.right.left = new TreeNode(5);
  root.right.right = new TreeNode(7);
  root.right.right.right = new TreeNode(8);

  // inorder(bstToGst(root));
  inorder(iterative(root));
 }

 public static void inorder(TreeNode node) {
  if (node != null) {
   inorder(node.left);
   System.out.print(node.val + " ");
   inorder(node.right);
  }
 }

 static int sum = 0;

 public static TreeNode bstToGst(TreeNode root) {
  if (root.right != null) {
   bstToGst(root.right);
  }
  sum = root.val = sum + root.val;

  if (root.left != null) {
   bstToGst(root.left);
  }
  return root;
 }

 public static TreeNode iterative(TreeNode root) {
  Deque<TreeNode> S = new ArrayDeque<>();

  TreeNode curr = root;
  int sum = 0;

  while (curr != null || !S.isEmpty()) {
   while (curr != null) {
    S.push(curr);
    curr = curr.right;
   }

   curr = S.pop();
   sum += curr.val;
   curr.val = sum;
   curr = curr.left;
  }
  return root;
 }

}
