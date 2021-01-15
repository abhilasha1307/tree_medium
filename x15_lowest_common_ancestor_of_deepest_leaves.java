package TREE.TREE_medium;

// see other sol
//map ,recursive, making a custom class, bfs
/*
====================================================
PROBLEM :) 1123
====================================================
Given the root of a binary tree, the depth of each node is the shortest distance to the root.
Return the smallest subtree such that it contains all the deepest nodes in the original tree.
A node is called the deepest if it has the largest depth possible among any node in the entire tree.
The subtree of a node is tree consisting of that node, plus the set of all descendants of that node.

The number of nodes in the tree will be in the range [1, 1000].
0 <= Node.val <= 1000
The values of the nodes in the tree are unique.
*/

/*
====================================================
APPROACH:)
====================================================

Time : O(n)
Space : O(h)
*/

public class x15_lowest_common_ancestor_of_deepest_leaves extends helper {
 int deepest_level = 0;
 treeNode result;

 public treeNode subtreeWithAllDeepest(treeNode root) {

  dfs(root, 0);
  return result;

 }

 private int dfs(treeNode node, int level) {
  if (node == null) {
   return level;
  }

  int left_level = dfs(node.left, level + 1);
  int right_level = dfs(node.right, level + 1);

  int Current_level = Math.max(left_level, right_level);

  deepest_level = Math.max(deepest_level, Current_level);

  if (left_level == deepest_level && right_level == deepest_level) {
   result = node;
  }

  return Current_level;
 }

 public static void preorder(treeNode node) {
  if (node != null) {
   System.out.print(node.data + " ");
   preorder(node.left);
   preorder(node.right);
  }
 }

 public static void main(String[] args) {
  treeNode root = new treeNode(3);
  root.left = new treeNode(5);
  root.right = new treeNode(1);
  root.left.left = new treeNode(6);
  root.left.right = new treeNode(2);
  root.left.right.left = new treeNode(7);
  root.left.right.right = new treeNode(4);
  root.right.left = new treeNode(0);
  root.right.right = new treeNode(8);

  x15_lowest_common_ancestor_of_deepest_leaves obj = new x15_lowest_common_ancestor_of_deepest_leaves();
  treeNode res = obj.subtreeWithAllDeepest(root);
  preorder(res);
 }

}