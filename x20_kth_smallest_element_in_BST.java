import java.util.*;

/*
================================================
PROBLEM:) 230
================================================
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Constraints:
The number of elements of the BST is between 1 to 10^4.
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
*/

/*
=====================================================
APPROACH :)
=====================================================

*/

/*
========================================================
ITERATIVE APPROACH:) using stack
=========================================================
public static int kthSmallest(treeNode root, int k)
{
 Stack<treeNode> S = new Stack<>();

 while(true)
 {
  while(root != null)
  {
   S.push(root);
   root = root.left
  }

  root = S.pop();
  if(--k == 0) return root.data;
  root = root.right;
 }
}

Time complexity: O(H + k), where H is a tree height. This complexity is defined by the stack, which contains at least H + k elements, since before starting to pop out one has to go down to a leaf. This results in O(log N + k) for the balanced tree and O(N + k)for completely unbalanced tree with all the nodes in the left subtree.

Space complexity: O(H) to keep the stack, where H is a tree height. That makes O(N) in the worst case of the skewed tree, and O(logN) in the average case of the balanced tree.
*/

public class x20_kth_smallest_element_in_BST extends helper {

 public static int kthSmallest(treeNode root, int k) {

  if (root == null) {
   return 0;
  }

  List<Integer> list = new LinkedList<>();
  inorder(root, list);
  int result = Util_Find(list, k);
  return result;
 }

 public static void inorder(treeNode node, List<Integer> list) {
  if (node != null) {
   inorder(node.left, list);
   list.add(node.data);
   inorder(node.right, list);
  }
 }

 public static int Util_Find(List<Integer> list, int k) {
  return list.get(k - 1);
 }

 public static void main(String[] args) {
  treeNode root = new treeNode(3);
  root.left = new treeNode(1);
  root.left.right = new treeNode(2);
  root.right = new treeNode(4);

  int k = 1;
  System.out.println(kthSmallest(root, k));
 }
}
