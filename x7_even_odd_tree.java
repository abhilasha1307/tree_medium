package TREE.TREE_medium;

import java.util.*;

/*
==============================================
PROBLEM :) 1609
==============================================
A binary tree is named Even-Odd if it meets the following conditions:

The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.
For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).
For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).

Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false.

The number of nodes in the tree is in the range [1, 105].
1 <= Node.val <= 106
*/

/*
==============================================
APPROACH:) worked as constraints are small, else TLE
==============================================
if there is only one element in the tree, it has to be at level zero and as zero is even (taken here) the number has to be odd
we make a different function to check on the whole tree

checkUtil :  
we make a queue to store the nodes at a given level
while the queue is not empty, we call Util function to check the conditions for nodes on the said level(pass level and list which contains the nodes in the Q)

Util : 
to check elements at every level; whether they satisfy the given conditions for the level or not

Time : O(n)
Space : O(n) (loose upper bound)
*/

/*
=================================================
BFS SOLUTION :)
=================================================
public static boolean isEvenOddTree(treeNode root)
{
  if(root == null)
  {
    return false;
  }
  if(root.left == null && root.right == null)
  {
    return root.val%2 ==1;
  }

  Queue<treeNode> Q = new LinkedList<>();
  Q.add(root);
  int level = 0;

  while(!Q.isEmpty())
  {
    int size = Q.size();
    int prev = level%2==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

    for(int i = 0; i<size;i++)
    {
      treeNode node = Q.poll();
      if((level%2 == 0 && node.val <= prev) || (level%2 == 1 && node.val >= prev) || (level%2 == node.val%2))
        return false;
      
      prev = node.data;
      if(node.left != null){
        node.add(node.left);}
      if(node.right != null){
        node.add(node.right);}
    }
    level++;
  }
  return true;
}

Time : O(N)
Space : O(N)
*/

public class x7_even_odd_tree extends helper {

  public static boolean isEvenOddTree(treeNode root) {
    if (root.left == null && root.right == null) {
      if (root.data % 2 == 0) {
        return false;
      }

      else
        return true;
    }

    return checkUtil(root, 0);
  }

  /*
   * to check call Util and enqueue children of current node in the queue for
   * checking
   */
  public static boolean checkUtil(treeNode root, int level) {
    Queue<treeNode> Q = new LinkedList<>();
    treeNode temp = root;
    Q.add(temp);

    while (!Q.isEmpty()) {
      ArrayList<treeNode> list = new ArrayList<>(Q);
      if (Util(list, level) == false)
        return false;

      int size = Q.size();
      for (int i = 0; i < size; i++) {
        temp = Q.poll();
        if (temp.left != null) {
          Q.add(temp.left);
        }
        if (temp.right != null) {
          Q.add(temp.right);
        }
      }
      level++;
    }
    return true;
  }

  /*
   * to check elements at every level; whether they satisfy the given conditions
   * for the level or not
   */

  public static boolean Util(ArrayList<treeNode> list, int level) {
    if (level % 2 == 0) {
      /* to check strictly increasing order */
      for (int i = 0; i < list.size() - 1; i++) {
        if (list.get(i).data >= list.get(i + 1).data) {
          return false;
        }
      }
      /* to check if all nodes have odd values */

      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).data % 2 == 0) {
          return false;
        }
      }
      return true;
    }

    else {

      /* to check strictly decreasing order */
      for (int i = 0; i < list.size() - 1; i++) {
        if (list.get(i).data <= list.get(i + 1).data) {
          return false;
        }
      }

      /* to check if all nodes have odd values */
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).data % 2 != 0)
          return false;
      }

      return true;
    }
  }

  public static void main(String[] args) {
    treeNode root = new treeNode(1);
    root.left = new treeNode(10);
    root.right = new treeNode(4);
    root.left.left = new treeNode(3);
    root.left.left.left = new treeNode(12);
    root.left.left.right = new treeNode(8);
    root.right.left = new treeNode(7);
    root.right.right = new treeNode(9);
    root.right.left.left = new treeNode(6);
    root.right.right.right = new treeNode(2);

    System.out.println(isEvenOddTree(root));
  }
}
