package TREE.TREE_medium;

/*
==============================================================
PROBLEM:) 1315
==============================================================
Given a binary tree, return the sum of values of nodes with even-valued grandparent.  (A grandparent of a node is the parent of its parent, if it exists.)
If there are no nodes with an even-valued grandparent, return 0.

The number of nodes in the tree is between 1 and 10^4.
The value of nodes is between 1 and 100.
*/

/*
==============================================================
APPROACH:)
==============================================================

*/
public class x14_sum_of_nodes_with_even_valued_grandparent extends helper {

 public static int sumEvenGrandparent(treeNode root) {
  int sum = 0;
  if (root == null) {
   return 0;
  }

  if (root.data % 2 == 0) {
   if (root.left != null) {
    if (root.left.left != null) {
     sum += root.left.left.data;
    }

    if (root.left.right != null) {
     sum += root.left.right.data;
    }
   }

   if (root.right != null) {
    if (root.right.left != null) {
     sum += root.right.left.data;
    }

    if (root.right.right != null) {
     sum += root.right.right.data;
    }
   }
  }

  sum += sumEvenGrandparent(root.left);
  sum += sumEvenGrandparent(root.right);

  return sum;

 }

 public static void main(String[] args) {
  treeNode root = new treeNode(6);
  root.left = new treeNode(7);
  root.right = new treeNode(8);
  root.left.left = new treeNode(2);
  root.left.left.left = new treeNode(9);
  root.left.right = new treeNode(7);
  root.left.right.left = new treeNode(1);
  root.left.right.right = new treeNode(4);

  root.right.left = new treeNode(1);
  root.right.right = new treeNode(3);
  root.right.right.right = new treeNode(5);

  System.out.println(sumEvenGrandparent(root));
 }

}