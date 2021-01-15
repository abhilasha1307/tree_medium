package TREE.TREE_medium;

/*
===========================================
PROBLEM:)

*/

/*
APPROACH:)

*/

import java.util.Stack;

public class x1_construct_BT_from_preorder_and_inorder_traversal extends helper {

 public static treeNode buildTree(int[] preorder, int[] inorder) {
  Stack<treeNode> stack = new Stack<>();
  Stack<treeNode> set = new Stack<>();

  treeNode root = null;

  for (int pre = 0, in = 0; pre < preorder.length;) {
   treeNode node = null;
   do {
    node = new treeNode(preorder[pre]);
    if (root == null) {
     root = node;
    }
    if (!stack.isEmpty()) {
     if (set.contains(stack.peek())) {
      set.remove(stack.peek());
      stack.pop().right = node;
     } else {
      stack.peek().left = node;
     }
    }
    stack.push(node);
   } while (preorder[pre++] != inorder[in] && pre < preorder.length);

   node = null;
   while (!stack.isEmpty() && in < inorder.length && stack.peek().data == inorder[in]) {
    node = stack.pop();
    in++;
   }

   if (node != null) {
    set.add(node);
    stack.push(node);
   }
  }

  return root;

 }

 static void preorder(treeNode root) {
  if (root != null) {
   System.out.print(root.data + " ");
   preorder(root.left);
   preorder(root.right);
  }
 }

 public static void main(String[] args) {
  int[] preorder = new int[] { 3, 9, 20, 15, 7 };
  int[] inorder = new int[] { 9, 3, 15, 20, 7 };

  treeNode root = buildTree(preorder, inorder);

  preorder(root);

 }
}
