import java.util.ArrayList;

//time: O(n), space: O(n)
public class x27_balance_BST extends helper {
 public static void main(String[] args) {
  treeNode root = new treeNode(1);
  root.right = new treeNode(2);
  root.right.right = new treeNode(3);
  root.right.right.right = new treeNode(4);

  treeNode node = balanceBST(root);
  inorder(node);
 }

 private static void inorder(treeNode node) {
  if (node != null) {
   inorder(node.left);
   System.out.print(node.data + " ");
   inorder(node.right);
  }
 }

 static ArrayList<Integer> list = new ArrayList<>();

 public static treeNode balanceBST(treeNode root) {
  if (root == null)
   return null;

  if (root.left == null && root.right == null)
   return root;

  inorder_list(root);
  return treeMaker(0, list.size() - 1);
 }

 private static void inorder_list(treeNode node) {
  if (node != null) {
   inorder_list(node.left);
   list.add(node.data);
   inorder_list(node.right);
  }
 }

 private static treeNode treeMaker(int start, int end) {
  if (start > end)
   return null;

  int mid = (start + end) / 2;
  treeNode node = new treeNode(list.get(mid));
  node.left = treeMaker(start, mid - 1);
  node.right = treeMaker(mid + 1, end);

  return node;
 }
}
