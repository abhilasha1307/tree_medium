// Time: O(N)
// Space: O(H), O(N) in worst case
//cur_max and third argument cur_min are the maximum and minimum values along the root to the current node, respectively.

public class x28_max_difference_in_node_and_ancestor extends helper {
 public static void main(String[] args) {
  treeNode root = new treeNode(8);

  root.left = new treeNode(3);
  root.left.left = new treeNode(1);
  root.left.right = new treeNode(6);
  root.left.right.left = new treeNode(4);
  root.left.right.right = new treeNode(7);

  root.right = new treeNode(10);
  root.right.right = new treeNode(13);
  root.right.right.left = new treeNode(14);

  System.out.println(maxAncestorDiff(root));
 }

 public static int maxAncestorDiff(treeNode root) {
  if (root == null) {
   return 0;
  }
  return Diff_helper(root, root.data, root.data);

 }

 public static int Diff_helper(treeNode node, int currMax, int currMin) {
  if (node == null) {
   return currMax - currMin;
  }

  currMax = Math.max(currMax, node.data);
  currMin = Math.min(currMin, node.data);
  int left = Diff_helper(node.left, currMax, currMin);
  int right = Diff_helper(node.right, currMax, currMin);

  return Math.max(left, right);
 }

}
