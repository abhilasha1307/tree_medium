//cartesian tree

public class x25_maximum_BT extends helper {
 public static void main(String[] args) {
  int[] arr = new int[] { 3, 1, 2, 6, 0, 5 };
  treeNode root = constructMaximumBinaryTree(arr);
  inorder(root);
 }

 public static void inorder(treeNode node) {
  if (node != null) {
   inorder(node.left);
   System.out.print(node.data + " ");
   inorder(node.right);
  }
 }

 public static treeNode constructMaximumBinaryTree(int[] nums) {
  return Util(nums, 0, nums.length);
 }

 public static treeNode Util(int[] nums, int l, int r) {
  if (l == r)
   return null;
  int index = Max(nums, l, r);

  treeNode root = new treeNode(nums[index]);

  root.left = Util(nums, l, index);
  root.right = Util(nums, index + 1, r);

  return root;
 }

 public static int Max(int[] nums, int l, int r) {
  int max_index = l;
  for (int i = l; i < r; i++) {
   if (nums[i] > nums[max_index]) {
    max_index = i;
   }
  }
  return max_index;
 }
}
