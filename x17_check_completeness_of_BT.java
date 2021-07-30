/*
===================================================
PROBLEM:)  958
===================================================
Given the root of a binary tree, determine if it is a complete binary tree.
In a complete binary tree, every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

The number of nodes in the tree is in the range [1, 100].
1 <= Node.val <= 1000
*/

/*
=========================================================
MY APPROACH :)
=========================================================
we count the total number of node in the tree given
and then we check if there is any node in the tree such that its index is greater than the number of nodes present in the tree
index of root is taken as 1

Time : O(N)
Space : O(N)
*/

/*
==================================================================
ITERATIVE SOLUTION :) inserts null value in the queue
==================================================================
public static boolean isComplete(treeNode root)
{
 if(root.left == null && root.right == null)
 {
  return true;
 }

 Queue<treeNode> Q = new LinkedList<>();
 Q.add(root);

 while(Q.peek != null)
 {
  treeNode node  = Q.poll();
  Q.add(node.left);
  Q.add(node.right);
 }

 while(!Q.isEmpty() && Q.peek == null)
 {
  Q.poll();
 }

 return Q.isEmpty();
}

Time : O(N)
Space : O(N)
*/

/*
============================================================================================================================================================================
ITERATIVE SOLUTION 2 : OPTIMIZATION
here we return false if we see a node with either left or right child null but there are still nodes after the current node which have children (or a even one child)
=============================================================================================================================================================================
public static boolean isComplete(treeNode root)
{
 if(root.left == null && root.right == null)
 {
  return true;
 }

 Queue<treeNode> Q = new LinkedList<>();
 Q.add(root);

 while(true) //bcoz going in the loop or coming out of the loop is not really dependent on the queue size. We break out of the loop when we see first node with a null child
 { 
  treeNode node = Q.poll();
  if(node.left == null)
  {
   if(node.right != null) reuturn false;
   break;
  }

  Q.add(node.left);
  if(node.right == null) break;
  Q.add(node.right);
 }

 while(!Q.isEmpty())
 {
  treeNode temp = Q.poll();
  if(temp.left != null || temp.right != null)
  {
   return false;
  }
 }

 return true;
}

Time : O(N)
Space : O(N)
*/
public class x17_check_completeness_of_BT extends helper {

 public static boolean isCompleteTree(treeNode root) {
  if (root.left == null && root.right == null) {
   return true;
  }

  int nodes = count(root);

  return Util(root, 1, nodes);
 }

 public static int count(treeNode node) {
  if (node == null) {
   return 0;
  }

  return (1 + count(node.left) + count(node.right));
 }

 public static boolean Util(treeNode root, int index, int total_nodes) {
  if (root == null) {
   return true;
  }

  if (index > total_nodes) {
   return false;
  }

  return (Util(root.left, 2 * index, total_nodes) && Util(root.right, 2 * index + 1, total_nodes));
 }

 public static void main(String[] args) {
  treeNode root = new treeNode(1);
  root.left = new treeNode(2);
  root.right = new treeNode(3);
  root.left.left = new treeNode(4);
  root.left.right = new treeNode(5);
  root.right.left = new treeNode(6);

  System.out.println(isCompleteTree(root));

 }
}
