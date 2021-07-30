/*
=========================================
1325
=========================================

Given a binary tree root and an integer target, delete all the leaf nodes with value target.
Note that once you delete a leaf node with value target, if it's parent node becomes a leaf node and has the value target, it should also be deleted (you need to continue doing that until you can't).

1 <= target <= 1000
The given binary tree will have between 1 and 3000 nodes.
Each node's value is between [1, 1000].
*/

/*
============================================
APPROACH:)
============================================

*/

/*
============================================
ITERATIVE APPROACH:)
============================================


*/
public class x10_delete_leaves_with_given_value extends helper {
 public static treeNode removeLeafNodes(treeNode root, int target) {
  if (root == null) {
   return root;
  }

  root.left = removeLeafNodes(root.left, target);
  root.right = removeLeafNodes(root.right, target);

  if (root.left == null && root.right == null && root.data == target) {
   return null;
  }

  return root;

 }

 public static void inorder(treeNode root) {
  if (root != null) {
   inorder(root.left);
   System.out.print(root.data + " ");
   inorder(root.right);
  }
 }

 public static void main(String[] args) {
  treeNode root = new treeNode(1);
  root.left = new treeNode(3);
  root.right = new treeNode(3);
  root.left.left = new treeNode(3);
  root.left.right = new treeNode(4);

  int target = 3;

  inorder(removeLeafNodes(root, target));
 }

}
