//O(n*h)

public class x26_construct_BST_from_preorder_traversal extends helper {
 public static void main(String[] args) {
  int[] arr = new int[] { 8, 5, 1, 7, 10, 12 };

  treeNode node = bstFromPreorder(arr);
  inorder(node);
 }

 public static void inorder(treeNode node) {
  if (node != null) {
   inorder(node.left);
   System.out.print(node.data + " ");
   inorder(node.right);
  }
 }

 public static treeNode bstFromPreorder(int[] preorder) {
  treeNode root = new treeNode(preorder[0]);
  for (int i = 1; i < preorder.length; i++) {
   Util(root, preorder[i]);
  }

  return root;
 }

 private static void Util(treeNode node, int val) {
  if (val > node.data) {
   if (node.right == null) {
    node.right = new treeNode(val);
   } else {
    Util(node.right, val);
   }
  } else {
   if (node.left == null) {
    node.left = new treeNode(val);
   } else {
    Util(node.left, val);
   }
  }
 }
}
