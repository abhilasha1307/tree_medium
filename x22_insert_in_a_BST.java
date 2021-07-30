/*
================================================
PROBLEM:)
================================================
You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

The number of nodes in the tree will be in the range [0, 104].
-108 <= Node.val <= 108
All the values Node.val are unique.
-108 <= val <= 108
It's guaranteed that val does not exist in the original BST.

==========================
Example:
==========================
    4                       4
   / \                     /  \
  2   7    ==>            2    7
 / \                     / \  /
1   3                   1   3 5

*/

/*
APPROACH:)

*/

public class x22_insert_in_a_BST extends helper {
    treeNode root;

    public static treeNode insertIntoBST(treeNode root, int val) {
        if (root == null) {
            root = new treeNode(val);
            return root;
        }

        if (val > root.data) {
            root.right = insertIntoBST(root.right, val);
        }

        else if (val < root.data) {
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }

    public static void inorder(treeNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    public static void main(String[] args) {
        x22_insert_in_a_BST obj = new x22_insert_in_a_BST();
        obj.root = new treeNode(4);
        obj.root.left = new treeNode(2);
        obj.root.right = new treeNode(7);
        obj.root.left.left = new treeNode(1);
        obj.root.left.right = new treeNode(3);

        int key = 5;
        treeNode node = insertIntoBST(obj.root, key);
        inorder(node);

    }
}
