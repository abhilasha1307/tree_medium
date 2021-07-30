/*
========================================
PROBLEM:) 236
=========================================
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the tree.
*/

/*
=================================================
APPROACH:)
=================================================


*/
public class x21_LCA_of_BT extends helper {

 public static treeNode lowestCommonAncestor(treeNode root, treeNode p, treeNode q) {

  if (root == null)
   return null;
  if (root == p || root == q)
   return root;
  treeNode left = lowestCommonAncestor(root.left, p, q);
  treeNode right = lowestCommonAncestor(root.right, p, q);
  if (left == null) {
   return right;
  }

  else if (right == null) {
   return left;
  }

  else {
   return root;
  }
 }

 public static void main(String[] args) {
  /*
   * treeNode root = new treeNode(3); root.left = new treeNode(5); root.right =
   * new treeNode(1); root.left.left = new treeNode(6); root.left.right = new
   * treeNode(2); root.left.right.left = new treeNode(7); root.left.right.right =
   * new treeNode(4); root.right.left = new treeNode(0); root.right.right = new
   * treeNode(8);
   */

  treeNode root = new treeNode(1);
  root.left = new treeNode(2);
  root.right = new treeNode(3);
  root.right.right = new treeNode(4);

  treeNode p = new treeNode(4);
  treeNode q = new treeNode(3);

  treeNode result = lowestCommonAncestor(root, p, q);
  if (result == null) {
   System.out.println(root.data);
  } else {
   System.out.println(result.data);
  }
 }
}
