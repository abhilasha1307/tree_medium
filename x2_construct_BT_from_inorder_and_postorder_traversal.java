import java.util.Stack;

public class x2_construct_BT_from_inorder_and_postorder_traversal extends helper {

 public static treeNode buildTree(int[] inorder, int[] postorder) {
  if (inorder.length == 0 || postorder.length == 0)
   return null;
  int ip = inorder.length - 1;
  int pp = postorder.length - 1;

  Stack<treeNode> stack = new Stack<treeNode>();
  treeNode prev = null;
  treeNode root = new treeNode(postorder[pp]);
  stack.push(root);
  pp--;

  while (pp >= 0) {
   while (!stack.isEmpty() && stack.peek().data == inorder[ip]) {
    prev = stack.pop();
    ip--;
   }
   treeNode newNode = new treeNode(postorder[pp]);
   if (prev != null) {
    prev.left = newNode;
   } else if (!stack.isEmpty()) {
    treeNode currTop = stack.peek();
    currTop.right = newNode;
   }
   stack.push(newNode);
   prev = null;
   pp--;
  }

  return root;
 }

 static void inorder(treeNode root) {
  if (root != null) {
   inorder(root.left);
   System.out.print(root.data + " ");
   inorder(root.right);
  }
 }

 public static void main(String[] args) {
  int[] inorder = new int[] { 9, 3, 15, 20, 7 };
  int[] postorder = new int[] { 9, 15, 7, 20, 3 };

  treeNode root = buildTree(inorder, postorder);
  inorder(root);

 }
}