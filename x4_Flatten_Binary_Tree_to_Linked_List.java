/*
==============================================
PROBLEM:)  114
==============================================
Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
*/

/*
===============================================
APPROACH:)
================================================
for current node we go left, if left is not null
once we reach leaf node, we return back to its parent an we will swap its sibling and this leaf node and make root.left = null
after swapping we will check the right subtree and do the same in this subtree
this is dfs approach, so we start swapping at leaves and then come up towards the root, swapping the left and right subtrees along the way

Time : O(n)
Space : O(h)
*/

/*
====================================================
ITERATIVE APPROACH:) using stack (dfs)
====================================================
treeNode root;
 public static void flatten(treeNode root) 
 {
  Stack<treeNode> S = new Stack<>();
  Node temp = root; 

  while(temp != null || !S.isEmpty())
  {
   if(temp.right != null)
   {
    S.push(temp.right);
   }

   temp.right = temp.left;
   temp.left = null;

   if(temp.right == null && !S.isEmpty())
   {
    temp.right = S.pop();
   }

   temp = temp.right;
  }
 }

 we make a stack which will be used to store the elements to the right of a current node, given that current_node.right != null
 after this we copy the left tree of the current node to the right and make the left side null
 if the right of the current node is null and stack is not empty, we pop from the stack and palce it at the right of current node
 if not we shift the current pointer to the right

 Time : O(N)
 Space : O(h)
*/
public class x4_Flatten_Binary_Tree_to_Linked_List extends helper {
    treeNode root;

    public static void flatten(treeNode root) {

        if (root == null)
            return;

        if (root.left == null && root.right == null)
            return;

        if (root.left != null) {
            flatten(root.left);

            treeNode temp = root.right;
            root.right = root.left;
            root.left = null;

            treeNode curr = root.right;
            /*
             * right subtree for a said node will be added after all the nodes of the left
             * subtree for that node are already placed(in right) this means at the last
             * node of this small linked list the right part is null and that is where we
             * will keep the nodes from the right subtree
             */
            while (curr.right != null) {
                curr = curr.right;
            }
            curr.right = temp;
        }

        flatten(root.right);
    }

    public static void inOrder(treeNode node) {

        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static void main(String[] args) {
        x4_Flatten_Binary_Tree_to_Linked_List obj = new x4_Flatten_Binary_Tree_to_Linked_List();
        obj.root = new treeNode(1);
        obj.root.left = new treeNode(2);
        obj.root.right = new treeNode(3);
        obj.root.left.left = new treeNode(4);
        obj.root.left.right = new treeNode(5);
        obj.root.right.left = new treeNode(6);
        obj.root.right.right = new treeNode(7);
        /*
         * obj.root.left.left.left = new treeNode(8); obj.root.left.left.right = new
         * treeNode(9); obj.root.left.right.left = new treeNode(10);
         * obj.root.left.right.right = new treeNode(11); obj.root.right.left.left = new
         * treeNode(12); obj.root.right.left.right = new treeNode(13);
         * obj.root.right.right.left = new treeNode(14); obj.root.right.right.right =
         * new treeNode(15);
         */

        flatten(obj.root);

        inOrder(obj.root);

    }
}
