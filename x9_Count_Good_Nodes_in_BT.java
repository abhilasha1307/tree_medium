/*
==================================
PROBLEM:) 1448
==================================
Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
Return the number of good nodes in the binary tree.

The number of nodes in the binary tree is in the range [1, 10^5].
Each node's value is between [-10^4, 10^4].
*/

/*
==================================
APPROACH:)
==================================


*/

public class x9_Count_Good_Nodes_in_BT extends helper {

 public static int goodNodes(treeNode root) {

  if (root == null) {
   return 0;
  }

  return Util(root, root.data);
 }

 public static int Util(treeNode node, int max) {
  if (node == null)
   return 0;
  int count = 0;
  if (node.data >= max) {
   max = node.data;
   count++;
  }

  return count += Util(node.left, max) + Util(node.right, max);
 }

 public static void main(String[] args) {

  treeNode root = new treeNode(3);
  root.left = new treeNode(1);
  root.right = new treeNode(4);
  root.left.left = new treeNode(3);
  root.right.left = new treeNode(1);
  root.right.right = new treeNode(5);

  System.out.println(goodNodes(root));
 }

}