/*
===========================================================
PROBLEM:) 129
===========================================================
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
An example is the root-to-leaf path 1->2->3 which represents the number 123.
Find the total sum of all root-to-leaf numbers.
Note: A leaf is a node with no children.

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
*/

/*
=======================================================
APPROACH:)
=======================================================


*/

public class x16_sum_root_to_leaf_numbers extends helper {

  /*
   * public static int sumNumbers(treeNode root) { List<String> res = new
   * ArrayList<>();
   * 
   * if (root == null) { return 0; }
   * 
   * Util(root, "", res);
   * 
   * int sum = 0; for (String S : res) { sum += Integer.parseInt(S); }
   * 
   * return sum; }
   * 
   * public static void Util(treeNode root, String s, List<String> list) { if
   * (root.left == null && root.right == null) { list.add(s + root.data); }
   * 
   * if (root.left != null) { Util(root.left, s + root.data, list); }
   * 
   * if (root.right != null) { Util(root.right, s + root.data, list); } }
   */

  public static int sumNumbers(treeNode root) {
    return sumNodes(root, 0);
  }

  private static int sumNodes(treeNode root, int currentSum) {
    if (root == null)
      return 0;
    currentSum = currentSum * 10 + root.data;
    if (root.left == null && root.right == null)
      return currentSum;
    int leftSum = sumNodes(root.left, currentSum);
    int rightSum = sumNodes(root.right, currentSum);
    return leftSum + rightSum;
  }

  public static void main(String[] args) {
    treeNode root = new treeNode(1);
    root.left = new treeNode(2);
    root.right = new treeNode(3);

    System.out.println(sumNumbers(root));
  }

}
