/*
======================================================
PROBLEM:) 1302
======================================================
Given a binary tree, return the sum of values of its deepest leaves.

The number of nodes in the tree is between 1 and 10^4.
The value of nodes is between 1 and 100.
*/

/*
===========================================================
APPROACH:)
===========================================================

*/

public class x13_Deepest_leaves_sum extends helper {

 public static int deepestLeavesSum(treeNode root) {

  int h = height(root);

  return findSum(root, 1, h);
 }

 public static int height(treeNode node) {
  if (node == null) {
   return 0;
  }

  if (node.left == null && node.right == null) {
   return 1;
  }

  int left_height = height(node.left);
  int right_height = height(node.right);

  if (left_height > right_height) {
   return (1 + left_height);
  } else {
   return 1 + right_height;
  }
 }

 public static int findSum(treeNode root, int C_level, int Level) {
  int sum = 0;

  if (root == null) {
   return 0;
  }

  if (root.left == null && root.right == null) {
   if (C_level == Level) {
    return root.data;
   }
  }

  sum += findSum(root.left, C_level + 1, Level);
  sum += findSum(root.right, C_level + 1, Level);

  return sum;
 }

 public static void main(String[] args) {
  treeNode root = new treeNode(1);
  root.left = new treeNode(2);
  root.right = new treeNode(3);
  root.left.left = new treeNode(4);
  root.left.right = new treeNode(5);
  root.left.left.left = new treeNode(7);
  root.left.left.right = new treeNode(9);

  root.right.right = new treeNode(6);
  root.right.right.left = new treeNode(10);
  root.right.right.right = new treeNode(8);

  System.out.println(deepestLeavesSum(root));

 }

}
