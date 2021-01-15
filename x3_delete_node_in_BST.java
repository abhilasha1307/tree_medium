package TREE.TREE_medium;

/*
=================================================
PROBLEM:) 450
=================================================
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.

The number of nodes in the tree is in the range [0, 104].
-105 <= Node.val <= 105
Each node has a unique value.
root is a valid binary search tree.
-105 <= key <= 105
*/

/*
===============================================
APPROACH:) //used inorder successor
===============================================
its a BST. we check if the key to be deleted is greater than the current node (go to the right subtree), or less than current node(go to the left subtree)
if we reach a node whose value is same as key, we check the left and right side 
if the left side is null we return the right side to be updated in the place of the key to be deleted and similar if the right side is null
if the left and right both are not null, we have to find the inorder successor (can be done with predeccessor as well) and replace root.data with the value of inorder successor and then delete the inorder successor

Time : O(N)
Space : O(N)
*/
public class x3_delete_node_in_BST extends helper {

 public static treeNode deleteNode(treeNode root, int key) {

  if (root == null) {
   return root;
  }

  if (key < root.data) {
   root.left = deleteNode(root.left, key);
  }

  else if (key > root.data) {
   root.right = deleteNode(root.right, key);
  }

  else {
   if (root.left == null) {
    return root.right;
   }

   else if (root.right == null) {
    return root.left;
   }

   else {
    root.data = minValue(root.right);

    root.right = deleteNode(root.right, root.data);
   }
  }
  return root;
 }

 static int minValue(treeNode root) {
  int min = root.data;
  while (root.left != null) {
   min = root.left.data;
   root = root.left;
  }
  return min;
 }

 static void inorder(treeNode root) {
  if (root != null) {
   inorder(root.left);
   System.out.print(root.data + " ");
   inorder(root.right);
  }
 }

 public static void main(String[] args) {
  treeNode root = new treeNode(5);
  root.left = new treeNode(3);
  root.right = new treeNode(6);
  root.left.left = new treeNode(2);
  root.left.right = new treeNode(4);
  root.right.right = new treeNode(7);

  int key = 3;

  inorder(root);
  treeNode result = deleteNode(root, key);
  System.out.println();
  inorder(result);

 }

}
