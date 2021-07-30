/*
====================================================
PROBLEM:) 687
====================================================
Given the root of a binary tree, return the length of the longest path, where each node in the path has the same value. This path may or may not pass through the root.
The length of the path between two nodes is represented by the number of edges between them.

The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000
The depth of the tree will not exceed 1000.
*/

/*
=====================================================
APPROACH:)
=====================================================


*/

public class x18_longest_univalue_path extends helper {
 public static void main(String[] args) {
  treeNode root = new treeNode(5);
  root.left = new treeNode(4);
  root.left.left = new treeNode(1);
  root.left.right = new treeNode(1);
  root.right = new treeNode(5);
  root.right.right = new treeNode(5);

  System.out.println(longestUnivaluePath(root));
 }

 static int ans;

 public static int longestUnivaluePath(treeNode root) {
  ans = 0;
  arrowLength(root);
  return ans;
 }

 public static int arrowLength(treeNode node) {
  if (node == null)
   return 0;
  int left = arrowLength(node.left);
  int right = arrowLength(node.right);
  int arrowLeft = 0, arrowRight = 0;
  if (node.left != null && node.left.data == node.data) {
   arrowLeft += left + 1;
  }
  if (node.right != null && node.right.data == node.data) {
   arrowRight += right + 1;
  }
  ans = Math.max(ans, arrowLeft + arrowRight);
  return Math.max(arrowLeft, arrowRight);
 }
}