import java.util.ArrayList;

/*
===============================================
PROBLEM:) 1530
==============================================
Given the root of a binary tree and an integer distance. A pair of two different leaf nodes of a binary tree is said to be good if the length of the shortest path between them is less than or equal to distance.

Return the number of good leaf node pairs in the tree.

The number of nodes in the tree is in the range [1, 2^10].
Each node's value is between [1, 100].
1 <= distance <= 10
*/

/*
==============================================
APPROACH:)
==============================================

*/

public class x8_number_of_good_leaf_node_pairs extends helper {

  int count = 0;

  public ArrayList<Integer> helper(treeNode root, int d) {
    if (root == null) {
      ArrayList<Integer> returnList = new ArrayList<>();
      returnList.add(0);
      return returnList;
    }
    if (root.left == null && root.right == null) {
      ArrayList<Integer> returnList = new ArrayList<>();
      returnList.add(1);
      return returnList;
    }
    ArrayList<Integer> left = helper(root.left, d);
    ArrayList<Integer> right = helper(root.right, d);
    for (int x : left) {
      for (int y : right) {
        if (x > 0 && y > 0 && x + y <= d) {
          count++;
        }
      }
    }
    ArrayList<Integer> returnList = new ArrayList<>();
    for (Integer x : left) {
      if (x > 0 && x < d)
        returnList.add(x + 1);
    }
    for (Integer x : right) {
      if (x > 0 && x < d)
        returnList.add(x + 1);
    }
    return returnList;
  }

  public int countPairs(treeNode root, int distance) {
    helper(root, distance);
    return count;
  }

  public static void main(String[] args) {
    treeNode root = new treeNode(1);
    root.left = new treeNode(2);
    root.right = new treeNode(3);
    root.left.left = new treeNode(4);
    root.left.right = new treeNode(5);
    root.right.left = new treeNode(6);
    root.right.right = new treeNode(7);
    int distance = 3;

    x8_number_of_good_leaf_node_pairs obj = new x8_number_of_good_leaf_node_pairs();

    System.out.println(obj.countPairs(root, distance));
  }

}
