import java.util.ArrayList;
import java.util.HashSet;

//IMP

/*
time = O(to_delete + N)
space = O(to_delete + H)
*/
public class x29_delete_nodes_return_forest extends helper {
 public static void main(String[] args) {
  treeNode root = new treeNode(1);
  root.left = new treeNode(2);
  root.left.left = new treeNode(4);
  root.left.right = new treeNode(5);

  root.right = new treeNode(3);
  root.right.left = new treeNode(6);
  root.right.right = new treeNode(7);

  int[] to_delete = new int[] { 3, 5 };
  ArrayList<treeNode> list = delNodes(root, to_delete);

  for (int i = 0; i < list.size(); i++) {
   System.out.println(list.get(i).data + " "); // [[1,2,null,4],[6],[7]]
  }
 }

 public static ArrayList<treeNode> delNodes(treeNode root, int[] to_delete) {
  ArrayList<treeNode> finalList = new ArrayList<>();
  if (root == null) {
   return finalList;
  }
  HashSet<Integer> set = new HashSet<>();
  for (int x : to_delete) {
   set.add(x);
  }

  deleteNodes(root, set, finalList);
  if (!set.contains(root.data)) {
   finalList.add(root);
  }
  return finalList;
 }

 private static treeNode deleteNodes(treeNode node, HashSet<Integer> set, ArrayList<treeNode> finalList) {

  if (node == null) {
   return null;
  }

  node.left = deleteNodes(node.left, set, finalList);
  node.right = deleteNodes(node.right, set, finalList);

  if (set.contains(node.data)) {
   if (node.left != null)
    finalList.add(node.left);
   if (node.right != null)
    finalList.add(node.right);

   return null;
  }
  return node;
 }
}
