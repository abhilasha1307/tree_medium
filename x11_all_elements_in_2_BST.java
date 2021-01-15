package TREE.TREE_medium;

import java.util.*;
//look for better solutions if any

/*
==================================================
PROBLEM:) 1305
===================================================
Given two binary search trees root1 and root2.
Return a list containing all the integers from both trees sorted in ascending order.

Each tree has at most 5000 nodes.
Each node's value is between [-10^5, 10^5].
*/

/*
===================================================
APPROACH:)
===================================================
*/
public class x11_all_elements_in_2_BST extends helper {

 public static List<Integer> getAllElements(treeNode root1, treeNode root2) {

  ArrayList<Integer> list = new ArrayList<>();

  inorder(root1, list);
  inorder(root2, list);

  Collections.sort(list);

  return list;
 }

 public static void inorder(treeNode node, List<Integer> list) {
  if (node == null) {
   return;
  }

  inorder(node.left, list);
  list.add(node.data);
  inorder(node.right, list);
 }

 public static void main(String[] args) {
  treeNode root1 = new treeNode(2);
  root1.left = new treeNode(1);
  root1.right = new treeNode(4);

  treeNode root2 = new treeNode(1);
  root2.left = new treeNode(0);
  root2.right = new treeNode(3);

  System.out.println(getAllElements(root1, root2));
 }
}
