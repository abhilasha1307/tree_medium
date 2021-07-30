/*
===========================================================
PROBLEM:) 951
===========================================================
For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child subtrees.
A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations.
Given the roots of two binary trees root1 and root2, return true if the two trees are flip equivelent or false otherwise.

The number of nodes in each tree is in the range [0, 100].
Each tree will have unique node values in the range [0, 99]
*/

/*
============================================================
APPROACH:)
============================================================

Time : O(n) //debug and watch 
https://leetcode.com/problems/flip-equivalent-binary-trees/discuss/200514/JavaPython-3-DFS-3-liners-and-BFS-with-explanation-time-and-space%3A-O(n).
Space : O(h)
*/
public class x12_flip_equivalent_BT extends helper {

  public static boolean flipEquiv(treeNode root1, treeNode root2) {
    if (root1 == null && root2 == null) {
      return true;
    }

    if (root1 == null || root2 == null) {
      return false;
    }

    return root1.data == root2.data && (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)
        || flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
  }

  public static void main(String[] args) {
    treeNode root1 = new treeNode(3);
    root1.left = new treeNode(2);
    root1.right = new treeNode(3);
    root1.right.left = new treeNode(6);
    root1.left.left = new treeNode(4);
    root1.left.right = new treeNode(5);
    root1.left.right.left = new treeNode(7);
    root1.left.right.right = new treeNode(8);

    treeNode root2 = new treeNode(3);
    root2.right = new treeNode(2);
    root2.left = new treeNode(3);
    root2.left.right = new treeNode(6);
    root2.right.left = new treeNode(4);
    root2.right.right = new treeNode(5);
    root2.right.right.left = new treeNode(8);
    root2.right.right.right = new treeNode(7);

    System.out.println(flipEquiv(root1, root2));

  }

}
