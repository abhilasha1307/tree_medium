
/*
=========================================
PROBLEM:) 98
=========================================
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
*/

/*
=========================================
APPROACH:)
=========================================
we have used root and left and right Integer variables to check in the left and right subtree
in the left subtree the elements should not be >= the present root, so we change the upper bound to root.data and leave lower bound(low) as it is
in the right, the elements should not be <= the present root, so we change the upper bound to root.data

if we find an element which is greater than the upper bound or smaller than the lower bound we return false

Time : O(n)
Space: O(h)
*/
public class x5_valid_BST extends helper {

 public static boolean isValidBST(treeNode root) {
  return valid(root, null, null);
 }

 public static boolean valid(treeNode root, Integer low, Integer high) {
  if (root == null) {
   return true;
  }

  if ((low != null && root.data <= low) || (high != null && root.data >= high)) {
   return false;
  }

  return (valid(root.left, low, root.data) && valid(root.right, root.data, high));
 }

 public static void main(String[] args) {

  treeNode root = new treeNode(2);
  root.left = new treeNode(1);
  // root.right = new treeNode(3);

  System.out.println(isValidBST(root));
 }
}