
//queue, hashmap

/*
=======================================
PROBLEM :) 662
=======================================
Given a binary tree, write a function to get the maximum width of the given tree. The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.
The given binary tree will have between 1 and 3000 nodes.
*/

/*
============================================
APPROACH:)
============================================
here to keep track of the width, we use depth and index of variables
depth of root = 0 and index of root  = 1
we add the index of the leftmost node of all the levels the list, every time we are on a new level, the depth at that level will be the same as the size of the list
current width at a level is the (index of the current node) - (index of the leftmost node at that level) + 1
list.get(depth) will give us index of the leftmost node at that level

then we calculate the left and the right width for the current node and return the maximum of three to the previous call

Time : O(n)
Space : O(h) 
(the size of the list made is also the same as the height of the tree as we are adding only leftmost nodes of the tree)
*/

/*
=======================================================
ITERATIVE APPROACH:)
========================================================
public static int widthOfBinaryTree(treeNode root)
{
  Queue<treeNode> Q = new Queue<>();
  Map<treeNode, Integer> M = new HashMap<>();

  Q.add(root);
  M.put(root,1);

  int curW = 0;
  int maxW = 0;

  while(!Q.isEmpty())
  {
    int size = Q.size();
    int start = 0;
    int end = 0;

    for(int i = 0; i<size; i++)
    {
      treeNode temp = Q.poll();
      if(i == 0)
      {
        start = M.get(temp);
      }
      if(i == size - 1)
      {
        end = M.get(temp);
      }

      if(temp.left != null)
      {
        Q.add(temp.left);
        M.put(temp.left, M.get(temp)*2);
      }

      if(temp.right != null)
      {
        Q.add(temp.right);
        M.put(temp.right, M.get(temp)*2 +1);
      }
    }
    curW = end-start+1;
    maxW = Math.max(curW,maxW);
  }

  return maxW;
}

Time : O(n)
Space : O(n) (here hashmap will occupy max space equal to height of the tree, and queue will in worst case give 2^h. But this is a very tight upper bound)

In a tree with n nodes, there's no possible way that you can ever get any more than n nodes into the queue at any one time, since no node will ever be enqueued twice. This gives an immediate upper bound of O(n). This isn't a tight bound, though, since if the tree is a degenerate linked list then the memory usage will just be O(1).

Your upper bound of O(2h) is also correct, but it's a weaker upper bound. In a tree with height h, there can be at most 2h nodes in the bottom layer, but there's no guarantee that this is actually the case. If the tree is a degenerate linked list, the height is O(n), and your bound of O(2h) will exponentially overapproximate the memory usage.
*/
import java.util.ArrayList;
import java.util.List;

public class x6_maximum_width_of_BT extends helper {
  public static int widthOfBinaryTree(treeNode root) {
    if (root == null) {
      return 0;
    }
    return helper(root, 0, 1, new ArrayList<Integer>());

  }

  private static int helper(treeNode root, int depth, int index, List<Integer> list) {
    if (root == null) {
      return 0;
    }
    // add index of leftmost node to list, at depth'th position in list
    if (depth == list.size()) {
      list.add(index);
    }
    int currWidth = index - list.get(depth) + 1;
    int leftWidth = helper(root.left, depth + 1, index * 2, list);
    int rightWidth = helper(root.right, depth + 1, index * 2 + 1, list);
    return Math.max(currWidth, Math.max(leftWidth, rightWidth));
  }

  public static void main(String[] args) {
    treeNode root = new treeNode(1);
    root.left = new treeNode(3);
    root.right = new treeNode(2);
    root.left.left = new treeNode(5);
    root.left.left.left = new treeNode(6);
    root.right.right = new treeNode(9);
    root.right.right.right = new treeNode(7);

    System.out.println(widthOfBinaryTree(root));
  }

}