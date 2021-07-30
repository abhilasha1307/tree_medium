/*
===============================================================
PROBLEM:)
==============================================================
Given a Binary Tree. Check whether it is a Sum Tree or not.
A Binary Tree is a Sum Tree in which value of each node x is equal to sum of nodes present in its left subtree and right subtree . An empty tree is also a Sum Tree as sum of an empty tree can be considered to be 0. A leaf node is also considered as a Sum Tree.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(Height of the Tree)

Constraints:
1 ≤ number of nodes ≤ 10^4

========================================================================
EXAMPLES:)
    3
  /   \    
 1     2

 OUTPUT: true

          10
        /    \
      20      30
    /   \ 
   10    10

OUTPUT: false
============================================================================
*/

/*
APPROACH:) intuitive; less efficient

public static boolean isSumTree(treeNode root)
{
 int ls;
 int rs;

 if(root == null || root.left == null && root.right == null)
 {
  return true;
 }

 ls = Sum(root.left);
 rs = Sum(root.right);

 if(root.data == ls+rs && isSumTree(root.left) == true && isSumTree(root.right) == true)
 {
  return true;
 }
 return false;
}

public static int Sum(treeNode node)
{
 if(node == null)
 {
  return 0;
 }

 return(node.data + Sum(node.left) + Sum(node.right));
}

*/

/*

*/
public class p1_Sum_tree extends helper {

  public static void main(String[] args) {
    treeNode root = new treeNode(18);
    root.left = new treeNode(6);
    root.right = new treeNode(8);
    root.left.left = new treeNode(4);
    root.left.right = new treeNode(2);
    root.right.left = new treeNode(7);
    root.right.right = new treeNode(1);

    System.out.println(isSumTree(root));
  }

  static boolean isSumTree(treeNode root) {
    if (root == null || isLeaf(root)) {
      return true;
    }

    int ls, rs;
    if (isSumTree(root.left) != false && isSumTree(root.right) != false) {
      if (root.left == null) {
        ls = 0;
      } else if (isLeaf(root.left) == true) {
        ls = root.left.data;
      } else {
        ls = 2 * root.left.data;
      }

      if (root.right == null)
        rs = 0;
      else if (isLeaf(root.right) != false)
        rs = root.right.data;
      else
        rs = 2 * (root.right.data);

      if ((root.data == rs + ls))
        return true;
      else
        return false;
    }

    return false;
  }

  static boolean isLeaf(treeNode node) {
    if (node == null)
      return false;
    if (node.left == null && node.right == null)
      return true;
    return false;
  }
}
