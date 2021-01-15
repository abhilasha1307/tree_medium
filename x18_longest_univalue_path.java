package TREE.TREE_medium;

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
*
public class x18_longest_univalue_path extends helper {
 int longestPath = 0;

 public int longestUnivaluePath(treeNode root) {

  if (root == null) {
   return 0;
  }

  if (root.left == null && root.right == null) {
   return 1;
  }

  return Util(root);

 }

 public int Util(treeNode root) {
  if (root == null) {
   return 0;
  }

  int Left_path = 0;
  int Right_path = 0;
  int Path = 0;

  int val = root.data;

  if (root.left != null && root.left.data == val) {
   return Util(root.left) + 1;
  }

  if (root.right != null && root.right.data == val) {
   return Util(root.right) + 1;
  }

  Left_path += Util(root.left);
  Right_path += Util(root.right);
  Path = Left_path + Right_path;

  return longestPath = Math.max(Path, longestPath);
 }

 public static void main(String[] args) {
  treeNode root = new treeNode(5);
  root.left = new treeNode(4);
  root.left.left = new treeNode(4);
  root.left.right = new treeNode(4);
  root.right = new treeNode(5);
  root.right.right = new treeNode(5);
  x18_longest_univalue_path obj = new x18_longest_univalue_path();
  System.out.println(obj.longestUnivaluePath(root));
 }

}
